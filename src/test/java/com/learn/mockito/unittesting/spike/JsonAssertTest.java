package com.learn.mockito.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResult = "{\"id\":1,\"name\":\"Bob\",\"price\":100,\"quantity\":200}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExpectForSpaces() throws JSONException {
		
		String expectedResult = "{\"id\": 1,\"name\":\"Bob\",\"price\":100,\"quantity\":200}";
		
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		
		String expectedResult = "{\"id\":1, \"name\":\"Bob\", \"price\":100}";
		
		JSONAssert.assertEquals(expectedResult, actualResult, false);
	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharecters() throws JSONException {
		
		String expectedResult = "{id:1, name:Bob, price:100}";
		
		JSONAssert.assertEquals(expectedResult, actualResult, false);
	}
	
	
}
