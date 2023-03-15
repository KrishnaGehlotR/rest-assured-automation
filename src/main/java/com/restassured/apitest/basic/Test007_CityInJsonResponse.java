package com.restassured.apitest.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test007_CityInJsonResponse {

	@Test
	public void verifyCityInJsonResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		
//		Get the JsonPath object instance from the Response Interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
//		Get the JsonPath object to get a String value of the node specified by the JsonPath: City
		String city = jsonPathEvaluator.get("City");
		
//		Print the city variable to see what we got
		System.out.println("City received from Response is : "+city);
		
		Assert.assertEquals(city, "Hyderabad","City name is not Hyderabad");
	}
	
	@Test
	public void printAllNodesInWeatherApi() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
//		Print city node
		System.out.println("City : "+jsonPathEvaluator.get("City"));
		
//		Print temperature node
		System.out.println("Temperature : "+jsonPathEvaluator.get("Temperature"));
		
//		Print humidity node
		System.out.println("Humidity : "+jsonPathEvaluator.get("Humidity"));
		
//		Print weather description node
		System.out.println("Weather Description : "+jsonPathEvaluator.get("Weather"));
		
//		Print wind speed
		System.out.println("Wind Speed : "+jsonPathEvaluator.get("WindSpeed"));
		
//		Print wind direction degree
		System.out.println("Wind Direction Degree : "+jsonPathEvaluator.get("WindDirectionDegree"));
	}	
}
