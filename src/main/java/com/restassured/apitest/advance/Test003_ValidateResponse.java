package com.restassured.apitest.advance;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

public class Test003_ValidateResponse {

	@Test
	public void verifyResponse() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
		param("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		param("radius", "5000").
		param("type", "museum").
		param("location", "51.503186,-0.126446").
		when().
		get("maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("results[0].scope", equalTo("GOOGLE")).and().
		body("results[0].name", equalTo("The British Museum")).and().
		body("results[13].name", equalTo("London Canal Museum")).and().
		body("results[13].vicinity", equalTo("12-13 New Wharf Road, London")).and().
		header("server", "scaffolding on HTTPServer2");
		System.out.println("Request is executed succesfully");
	}
}