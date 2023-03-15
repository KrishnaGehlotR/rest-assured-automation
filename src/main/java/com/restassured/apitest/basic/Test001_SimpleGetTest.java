package com.restassured.apitest.basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Test001_SimpleGetTest {

	@Test
	public void getWeatherDetails() {
//		Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
//		Get the RequestSpecification of the request that you want to sent to the server.
//		The server is specified by the BaseURI that we have specified in the above steps.
		RequestSpecification httpRequest = RestAssured.given();
		
//		Make a request to server by specifying the method Type and the method URL.
//		This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Now let us print the body of the message to see what response
//		We have received from the server.
		ResponseBody<?> responseBody = response.getBody();
		String responseBodyMessage = responseBody.asString();
		System.out.println("Response body is ==> "+responseBodyMessage);
		
		System.out.println("Response body is ==> "+response.asString());
	}
}