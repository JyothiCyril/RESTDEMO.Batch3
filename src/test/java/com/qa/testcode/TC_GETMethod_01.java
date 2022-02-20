package com.qa.testcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class TC_GETMethod_01 {
	
	@Test
	public void GETDemo() {
		
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		
		
		String asString = res.asString();
		System.out.println(asString);
		
		ResponseBody body = res.getBody();
		String asString2 = body.asString();
		System.out.println(asString2);
		
		
		int statusCode = res.getStatusCode();
		System.out.println("The status code return is : " + statusCode);
		
		String header = res.getHeader("content-type");
		System.out.println(header);
		
		String statusLine = res.getStatusLine();
		System.out.println(statusLine);
		
		long time = res.getTime();
		System.out.println(time);
		
		
		Assert.assertEquals(statusCode, "200");
		
		
	}

}
