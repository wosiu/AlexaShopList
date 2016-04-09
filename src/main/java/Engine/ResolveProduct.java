package Engine;

import pl.edu.mimuw.students.wosiu.scraper.ConnectionException;
import pl.edu.mimuw.students.wosiu.scraper.alexa.*;

import java.util.List;

public class ResolveProduct {

	private TranslateExecutor translator = null;

	public ResolveProduct() throws ConnectionException {
		translator = new TranslateExecutor();
	}

	public void resolve(String productName) {
		// translate
		String productNameTr = translator.translate(productName);

		List offers = scrapOffers(productNameTr);

		List best = agregateOffers(offers);

		store(best);
	}

	private void store(List best) {
		// TODO !
	}

	private List agregateOffers(List offers) {
		// TODO !
		return null;
	}

	private List scrapOffers(String productNameTr) {
		// TODO !
		return null;
	}


}
