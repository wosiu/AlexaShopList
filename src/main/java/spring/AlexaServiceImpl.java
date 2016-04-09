package spring;

import engine.EngineRuntimeException;
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
		try {
			resolveProduct.resolve(productName);
			resolve.setStatus("OK");
		} catch(EngineRuntimeException e) {
			resolve.setStatus("FAIL");
			resolve.setMsg(e.getMessage());
		}
		return resolve;
	}
}
