package com.blazedemo.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.blazedemo.constants.FrameworkConstants;

public class ConfigReader {
	private static Properties properties;

	static {

		try {

			properties = new Properties();

			FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_PATH);

			properties.load(fis);

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static String get(String key) {

		return properties.getProperty(key);
	}
}
