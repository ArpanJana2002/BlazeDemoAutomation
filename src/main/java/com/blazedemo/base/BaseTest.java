package com.blazedemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.blazedemo.utils.ConfigReader;
import com.blazedemo.utils.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = DriverFactory.getDriver();

		driver.get(ConfigReader.get("url"));
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}
	}

}
