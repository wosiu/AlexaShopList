package engine;

import db.AlexaDAO;
import db.Offer;
import db.Search;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.edu.mimuw.students.wosiu.scraper.ConnectionException;
import pl.edu.mimuw.students.wosiu.scraper.ProductResult;
import pl.edu.mimuw.students.wosiu.scraper.alexa.ProductScrapExecutor;
import pl.edu.mimuw.students.wosiu.scraper.alexa.TranslateExecutor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class ResolveProductImpl implements ResolveProduct{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public boolean TEST_MODE = false;

	@Autowired
	AlexaDAO dao;

	private TranslateExecutor translator = null;
	private ProductScrapExecutor scraper = null;

	public ResolveProductImpl() throws ConnectionException {
		translator = new TranslateExecutor();
		scraper = new ProductScrapExecutor();
	}

	public void resolve(String productName) {
		// translate
		logger.info("Resolve product: " + productName);

		List offers = scrapOffers(productName);
		if (offers == null || offers.isEmpty()) {
			throw new EngineRuntimeException("Couldn't scrap products from shops");
		}

		//List best = agregateOffers(offers);

		if (!TEST_MODE) {
			store(offers, productName);
		} else {
			System.out.println(offers);
		}

		// TODO? send feedback
	}

	public void resolveEN(String productName) {
		// translate
		logger.info("Resolve product: " + productName);
		String productNameTr = translator.translate(productName);
		if (StringUtils.isBlank(productNameTr )) {
//			throw new EngineRuntimeException("Cannot translate product");
			productNameTr = productName;
		}
		logger.info("Translated: " + productName);

		resolve(productNameTr);
	}


	private List scrapOffers(String productNameTr) {
		logger.info("Scrap: " + productNameTr);
		return scraper.scrap(productNameTr);
	}

//	private List agregateOffers(List offers) {
//		logger.info("Agregate offers, size: " + offers.size());
//		return Arrays.asList(offers.get(0));
//	}

	private void store(List<ProductResult> best, String productName) {
		if (best != null && !best.isEmpty()) {
			final ProductResult pr = best.get(0);
			final Long idSearch = dao.addSearch(new Search(productName, 1, new Date()));

			List<Offer> offers = new LinkedList<>();
			best.stream().forEach(s -> {
						final Offer offer = new Offer(s.getProduct(), s.getPrice(), s.getShop(), s.getShopURL(), idSearch);
						final Long offerId = dao.addOffer(offer);
						offer.setId(offerId);
						offers.add(offer);
					}
			);

			final Optional<Offer> min =
					offers.stream().min((o1, o2) -> Float.compare(Float.valueOf(o1.getPrice()), Float.valueOf(o2.getPrice())));
			dao.updateSearch(idSearch, min.get().getId());
		} else {
			logger.warn("Trying to store empty best");
		}
	}
}
