package spring;

import json.ResolveResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlexaController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AlexaService alexaService;

	@RequestMapping("/")
	@ResponseBody
	String test() {
		return "test";
	}

	@RequestMapping("/resolve/{productName}")
	@ResponseBody
	ResolveResponse resolve(@PathVariable String productName) {
		log.info("Received resolve request");
		return alexaService.resolve(productName);
	}

}