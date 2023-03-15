package com.restassured.apitest.advance;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

public class Test002_GetResponse {

	@Test
	public void getResponseOfGooglePlaceApi() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
		param("location", "51.503186,-0.126446").
		param("radius", "5000").
		param("type", "museum").
		param("keyword", "cruise").
		param("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		when().
		get("maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("results[0].scope", equalTo("GOOGLE")).and().
		body("results[0].name", equalTo("London Canal Museum"));
		System.out.println("Request is executed succesfully");
	}
}