/*
 *------------------------------------------------------------------------------
 * Project Name  : XXXXXX
 *         Module: BATCH XXXX
 *
 * Created Author: Junlapong
 *         Date  : 2015-08-13
 *
 * Updated $Revision: 1 $:
 *         $Author: Teerawat $:
 *         $Date: 2015-08-13 09:10:15 $:
 *------------------------------------------------------------------------------
 * Copyright (c) 2012 Bank of Ayudhya Public Company Limited.
 *==============================================================================
 */

package com.company.app;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.app.module.ModuleService;

public class MainApp {

	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

	public enum ExitCode {
		NORMAL(0), ABNORMAL(-1);
		private int value;
		private ExitCode(int value) { this.value = value;}
		public int toInt() { return value; }
	}

	static {
		Locale.setDefault(Locale.ENGLISH);
	}

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("[ BATCH START: {}]", new Date());

		int exitCode = ExitCode.ABNORMAL.toInt();

		try {

			if (args != null && args.length >= 1) {
				logger.debug("args 1: {}", args[0]);
			} else {
				logger.debug("no arguments");
			}

			ModuleService service = new ModuleService();
			service.sayHello("BAY");
			
			exitCode = ExitCode.NORMAL.toInt();

		} catch (Exception e) {
			logger.error("ERROR: ", e);
		} finally {
			logger.info("[   BATCH END: {}]", new Date());
		}

		System.exit(exitCode);
	}

}
