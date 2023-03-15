package com.restassured.apitest.advance;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Test007_ParseXMLResponse {

	@Test
	public void verifyPostXmlRequet() throws IOException {
		String requestBody = new String(Files.readAllBytes(Paths.get("./postPayloadsXml/postPayload.xml")));
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = given().
		queryParam("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		body(requestBody).
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().
		extract().response();
		
		String responseString = response.asString();
		System.out.println("Response as string : \n"+responseString);
		
		XmlPath xmlResponse = new XmlPath(responseString);
		String placeId = xmlResponse.get("PlaceAddResponse.place_id");
		System.out.println("************************");
		System.out.println(placeId);
	}
}