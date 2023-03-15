package com.restassured.apitest.basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Test005_ResponseBody {

	@Test
	public void getWeatherStatusLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
		ResponseBody<?> body = response.getBody();
//		By using the ResponseBody.asString() method, we can convert the body
//		into the string representation.
		System.out.println("Response body is : "+body.asString());
	}
}