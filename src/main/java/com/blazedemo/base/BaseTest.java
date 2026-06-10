package com.blazedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.blazedemo.utils.ConfigReader;
import com.blazedemo.utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
    // Initialize Chrome options
    ChromeOptions options = new ChromeOptions();
    options.setBinary("/usr/bin/chromium-browser"); // Use the CI environment path
    options.addArguments("--start-maximized");
    options.addArguments("--disable-blink-features=AutomationControlled");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    
    // Initialize WebDriver
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(options);
    
    // Navigate to base URL
    driver.navigate().to(ConfigReader.get("baseURL"));
}

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
