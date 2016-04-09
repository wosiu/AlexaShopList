package engine;

import org.apache.commons.logging.Log;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.mimuw.students.wosiu.scraper.Selector;
import pl.edu.mimuw.students.wosiu.scraper.Utils;
import pl.edu.mimuw.students.wosiu.scraper.alexa.ProductScrapExecutor;
import pl.edu.mimuw.students.wosiu.scraper.selectors.AlexaTesco;

import java.net.URL;
import java.util.List;

public class EngineTest {
	@Before
	public void init() {
		org.apache.log4j.BasicConfigurator.configure();
	}

	@Test
	public void testScrap() throws Exception {
		ResolveProductImpl resolveProduct = new ResolveProductImpl();
		resolveProduct.TEST_MODE = true;
		//resolveProduct.resolve("milk");
		resolveProduct.resolve("blue cheese");
	}
}
