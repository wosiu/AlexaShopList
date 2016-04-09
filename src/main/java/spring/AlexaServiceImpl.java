package spring;

import engine.ResolveProduct;
import json.ResolveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlexaServiceImpl implements AlexaService {

	@Autowired
	ResolveProduct resolveProduct;

	@Override
	public ResolveResponse resolve(String productName) {
		final ResolveResponse resolve = new ResolveResponse();
		//resolveProduct.resolve(productName);
		resolve.setStatus("OK");
		return resolve;
	}
}
