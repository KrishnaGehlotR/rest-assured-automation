package com.restassured.apitest.advance;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Test001_GetStatusCode {

	@Test
	public void getStatusCodeOfGooglePlaceApi() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RequestSpecification httpRequest = RestAssured.given().param("location", "33.8670522,151.1957362").param("radius", "1500").param("type", "restaurant").param("keyword", "cruise").param("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U");
		Response response = httpRequest.request(Method.GET, "maps/api/place/nearbysearch/json");
		int statusCode = response.statusCode();
		System.out.println("Status code : "+statusCode);
		
		given().
		param("location", "33.8670522,151.1957362").
		param("radius", "1500").
		param("type", "restaurant").
		param("keyword", "cruise").
		param("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		when().
		get("maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200);
		System.out.println("Request is executed succesfully");
	}
}