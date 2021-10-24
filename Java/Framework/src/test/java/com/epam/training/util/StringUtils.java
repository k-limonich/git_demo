package com.epam.training.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static final String EMPTY_STRING = "";

	public static String buildLocator(String basePart, String specificPart) {
		return String.format(basePart, specificPart);
	}

	public static String extractSubstring(String string, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.find() ? matcher.group() : EMPTY_STRING;
	}
}
