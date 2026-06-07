package com.blazedemo.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.blazedemo.constants.FrameworkConstants;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String fileName) {

		try {

			File screenshotDir = new File(FrameworkConstants.SCREENSHOT_PATH);

			if (!screenshotDir.exists()) {

				screenshotDir.mkdirs();
			}

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String destinationPath = FrameworkConstants.SCREENSHOT_PATH + fileName + ".png";

			File destination = new File(destinationPath);

			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return destinationPath;

		} catch (Exception e) {

			e.printStackTrace();

			return "";
		}
	}
}