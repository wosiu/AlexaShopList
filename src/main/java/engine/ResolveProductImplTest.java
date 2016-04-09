package engine;

import org.junit.Test;
import pl.edu.mimuw.students.wosiu.scraper.ConnectionException;
import pl.edu.mimuw.students.wosiu.scraper.alexa.TranslateExecutor;

public class ResolveProductImplTest {

	@Test
	public void translateTest() throws ConnectionException {
		TranslateExecutor executor = new TranslateExecutor();
		final String milk = executor.translate("beer");
		System.out.println(milk);
	}
}


