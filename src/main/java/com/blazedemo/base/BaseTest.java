package com.blazedemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.blazedemo.utils.ConfigReader;
import com.blazedemo.utils.DriverFactory;
protected WebDriver driver;

@BeforeTest
public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get(ConfigReader.get("baseUrl"));
}

@AfterTest
public void teardown() {
    if (driver != null) {
        driver.quit();
    }
}
