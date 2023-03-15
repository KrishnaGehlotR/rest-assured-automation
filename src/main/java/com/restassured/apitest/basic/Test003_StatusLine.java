package com.restassured.apitest.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test003_StatusLine {

	@Test
	public void getWeatherStatusLine() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Get the status line from the Response and store it in a variable called statusLine
		String statusLine = response.getStatusLine();
		System.out.println("Status Line : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "The web service is not good");
	}
}