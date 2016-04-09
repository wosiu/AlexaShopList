package Engine;

import org.apache.log4j.Logger;
import pl.edu.mimuw.students.wosiu.scraper.ConnectionException;
import pl.edu.mimuw.students.wosiu.scraper.alexa.*;

import java.util.Arrays;
import java.util.List;

public class ResolveProduct {
	private static final Logger logger = Logger.getLogger(ResolveProduct.class);
	private TranslateExecutor translator = null;
	private ProductScrapExecutor scraper = null;

	public ResolveProduct() throws ConnectionException {
		translator = new TranslateExecutor();
		scraper = new ProductScrapExecutor();
	}

	public void resolve(String productName) {
		// translate
		logger.info("Resolve product: " + productName);
		String productNameTr = translator.translate(productName);

		List offers = scrapOffers(productNameTr);

		//List best = agregateOffers(offers);

		store(offers);

		// TODO? send feedback
	}

	private List scrapOffers(String productNameTr) {
		logger.info("Scrap: " + productNameTr);
		// TODO in scraper...
		return scraper.scrap(productNameTr);
	}

	private List agregateOffers(List offers) {
		logger.info("Agregate offers, size: " + offers.size());
		// TODO ! This is mock!
		return Arrays.asList(offers.get(0));
	}

	private void store(List best) {
		logger.info("Store, size: " + best.size());
		// TODO !
	}
}
