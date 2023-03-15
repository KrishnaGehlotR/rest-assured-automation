package com.restassured.apitest.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test002_StatusCode {

	@Test
	public void getWeatherDetailsOfValidCity() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Get the status code from the Response. In case of a successful interaction with the web service,
//		we should get a status code of 200.
		int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		Assert.assertEquals(statusCode, 200, "The web service is not good");
	}
	
	@Test
	public void getWeatherDetailsOfInvalidCity() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "7877878787");
		
//		Get the status code from the Response. In case of a successful interaction with the web service,
//		we should get a status code of 200.
		int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		Assert.assertEquals(statusCode, 200, "The web service is not good");
	}
}