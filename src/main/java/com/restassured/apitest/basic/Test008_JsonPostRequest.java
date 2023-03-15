package com.restassured.apitest.basic;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test008_JsonPostRequest {

	@SuppressWarnings("unchecked")
	@Test
	public void requestJsonPostObject() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
//		Create json object which contains all the fields
//		JsonObject is a class that represents a simple JSON.
//		We can add Key-Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender");
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "someuser@gmail.com");
		
//		Add Json body in the request and send the request 
//		Add a header stating the Request body is a JSON
		request.header("Content-Type","application/json");
		
//		Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		
//		Post the request and check the response
		Response response = request.post("/register");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "Correct Success code was returned", "OPERATION_SUCCESS");
	}
}
