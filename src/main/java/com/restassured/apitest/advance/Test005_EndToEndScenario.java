package com.restassured.apitest.advance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test005_EndToEndScenario {
	
	public String requestBody = "{"+
			  "\"location\": {"+
			    "\"lat\": -33.8669710,"+
			    "\"lng\": 151.1958750"+
			  "},"+
			  "\"accuracy\": 50,"+
			  "\"name\": \"Google Shoes!\","+
			  "\"phone_number\": \"(02) 9374 4000\","+
			  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
			  "\"types\": [\"shoe_store\"],"+
			  "\"website\": \"http://www.google.com.au/\","+
			  "\"language\": \"en-AU\""+
			"}"; 

	@Test
	public void validatePostRequestResponse() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = given().
		queryParam("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		body(requestBody).
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().
		extract().response();
		System.out.println("Response : "+response);
		
		String responseString = response.asString();
		System.out.println("Response as string : \n"+responseString);
		
		
		JsonPath jsonRequest = new JsonPath(responseString);
		System.out.println("Json path : "+jsonRequest);
		
		given().queryParam("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		body("\"place_id\":\""+jsonRequest.get("place_id")+"\"").
		when().post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().body("status", equalTo("OK"));
	}
}
