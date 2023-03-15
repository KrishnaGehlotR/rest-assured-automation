package com.restassured.apitest.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Test006_ResponseBodyAssert {

	@Test
	public void weatherMessageBodyAssertContains() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Retrieve the body of the response
		ResponseBody<?> body = response.getBody();
		
//		To check for sub string presence get the Response body as a string.
//		Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Hyderabad"), true);
	}
	
	@Test
	public void weatherMessageBodyAssertIgnoreCase() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Retrieve the body of the response
		ResponseBody<?> body = response.getBody();
		
//		To check for sub string presence get the Response body as a string.
//		Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.toLowerCase().contains("hyderabad"), true);
	}
}
