package com.restassured.apitest.advance;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test006_PostXmlRequest {

	@Test
	public void verifyPostXmlRequet() throws IOException {
		String requestBody = new String(Files.readAllBytes(Paths.get("./postPayloadsXml/postPayload.xml")));
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = given().
		queryParam("key", "AIzaSyB_jLAfkUKpUHpo7yVWtzbwdfaZRgWJW0U").
		body(requestBody).
		when().post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().
		extract().response();
		System.out.println("Response : \n"+response.asString());
	}
}
