package com.blazedemo.utils;

import java.io.File;

import com.blazedemo.constants.FrameworkConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
	private static JsonNode jsonNode;

	static {

		try {

			ObjectMapper mapper = new ObjectMapper();

			jsonNode = mapper.readTree(new File(FrameworkConstants.TESTDATA_PATH));

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static String get(String key) {

		return jsonNode.get(key).asText();
	}

}
