package com.blazedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.blazedemo.constants.FrameworkConstants;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getReport() {

		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);

			spark.config().setReportName("BlazeDemo Automation Report");

			spark.config().setDocumentTitle("Execution Report");

			extent = new ExtentReports();

			extent.attachReporter(spark);
		}

		return extent;
	}

}
