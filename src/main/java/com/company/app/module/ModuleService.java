package com.company.app.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleService {

	private static final Logger logger = LoggerFactory.getLogger(ModuleService.class);

	public void sayHello(String name) {
		logger.info("Hello {}", name);
	}
}
