package com.epam.training.service;

public class SearchTerm {

	private static final String TESTDATA_GOOGLE_SEARCH_TERM = "testdata.google.search.term";

	public static String fromProperty() {
		return TestDataReader.getTestData(TESTDATA_GOOGLE_SEARCH_TERM);
	}
}
