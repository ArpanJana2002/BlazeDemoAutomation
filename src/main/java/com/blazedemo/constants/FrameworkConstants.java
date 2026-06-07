package com.blazedemo.constants;

public class FrameworkConstants {
	private FrameworkConstants() {
	}

	public static final String CONFIG_PATH = "src/test/resources/config/config.properties";

	public static final String TESTDATA_PATH = "src/test/resources/testdata/bookingData.json";

	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/screenshots/";

	public static final String REPORT_PATH = System.getProperty("user.dir") + "/reports/AutomationReport.html";

}
