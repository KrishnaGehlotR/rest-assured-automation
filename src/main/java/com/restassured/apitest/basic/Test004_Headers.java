package com.restassured.apitest.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test004_Headers {

	@Test
	public void getHeaderOfWeatherApi() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		 Reader header of a give name. In this line we will get
//		 Header named Content-Type
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value : "+contentType);
		
//		 Reader header of a give name. In this line we will get
//		 Header named Server
		String serverType = response.header("Server");
		System.out.println("Server value : "+serverType);
		
//		 Reader header of a give name. In this line we will get
//		 Header named Server
		String acceptLangauage = response.header("Content-Encoding");
		System.out.println("Content Encoding : "+acceptLangauage);
	}
	
	@Test
	public void iteratingOverHeaders() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Get all the headers. Return value is of type Headers.
//		Headers class implements Iterable inteface, hence we
//		can apply an advance for loop to go through  all Headers
//		as shown in the code below
		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println("Key : "+header.getName()+" ==Value : "+header.getValue());
		}
	}
	
	@Test
	public void validateAllHeaders() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
//		Reader header of a give name. In this line we will get Header named Content-Type
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType,"application/json");
		
//		Reader header of a give name. In this line we will get Header named Server
		String serverType = response.header("Server");
		Assert.assertEquals(serverType,"nginx/1.12.2");
		
//		Reader header of a give name. In this line we will get Header Content-Encoding
		String acceptLangauage = response.header("Content-Encoding");
		Assert.assertEquals(acceptLangauage,"gzip");
		
//		Reader header of a give name. In this line we will get Header Date
		String date = response.header("Date");
		Assert.assertEquals(date,"Sat, 02 Jun 2018 13:25:14 GMT");
		
//		Reader header of a give name. In this line we will get Header Content-Length
		String contentLength = response.header("Content-Length");
		Assert.assertEquals(contentLength,"164");
		
//		Reader header of a give name. In this line we will get Header Connection
		String connection = response.header("Connection");
		Assert.assertEquals(connection,"keep-alive");
		
//		Reader header of a give name. In this line we will get Header Cache-Control
		String cacheControl = response.header("Cache-Control");
		Assert.assertEquals(cacheControl,"max-age=2592000");
		
//		Reader header of a give name. In this line we will get Header Expires
		String expires = response.header("Expires");
		Assert.assertEquals(expires,"Mon, 02 Jul 2018 13:25:14 GMT");
		
//		Reader header of a give name. In this line we will get Header Vary
		String vary = response.header("Vary");
		Assert.assertEquals(vary,"Accept-Encoding,User-Agent");
		
//		Reader header of a give name. In this line we will get Header Access-Control-Allow-Origin
		String accessControlAllowOrigin = response.header("Access-Control-Allow-Origin");
		Assert.assertEquals(accessControlAllowOrigin,"*");
	}
}