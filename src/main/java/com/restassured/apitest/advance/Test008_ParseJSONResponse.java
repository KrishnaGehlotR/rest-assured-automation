package com.restassured.apitest.advance;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test008_ParseJSONResponse {

	@Test
	public void verifyPostXmlRequet() throws IOException {
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = given().
		param("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		param("radius", "5000").
		param("type", "cruise").
		param("location", "51.503186,-0.126446").
		when().
		get("maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).
		extract().response();
		
		String responseString = response.asString();
//		System.out.println("Response as String : \n"+responseString);
		
		JsonPath jsonResponse = new JsonPath(responseString);
		int nodeSize = jsonResponse.getInt("results.size()");
		for (int i = 0; i < nodeSize; i++) {
			String name = jsonResponse.getString("results["+i+"].name");
			System.out.println("Name["+i+"] : "+name);
		}
	}
}