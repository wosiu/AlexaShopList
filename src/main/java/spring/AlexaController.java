package spring;

import json.ResolveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlexaController {

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
		return alexaService.resolve(productName);
	}

}