package spring;

import engine.ResolveProduct;
import engine.ResolveProductImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.mimuw.students.wosiu.scraper.ConnectionException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Bean
	ResolveProduct resolveProduct() throws ConnectionException {
		return new ResolveProductImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
