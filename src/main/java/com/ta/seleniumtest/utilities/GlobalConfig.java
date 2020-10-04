package com.ta.seleniumtest.utilities;

import java.util.Properties;

public class GlobalConfig {
	
	private static GlobalConfig globalConfigInstance;

	public GlobalConfig() {
		// TODO Auto-generated constructor stub
	}
	
	public static GlobalConfig getInstance() {
		if (globalConfigInstance == null) {
			globalConfigInstance = new GlobalConfig();
		}
		return globalConfigInstance;
	}
	
	private String testDataFileUrl;
	
	public String getTestDataFileUrl() {
		return testDataFileUrl;
	}

	public void configureInstance(Properties properties) {
		testDataFileUrl = properties.getProperty("TestDataFile_URL");
	}

}
