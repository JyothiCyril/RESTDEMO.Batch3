package com.qa.testcode;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TC_PUTMethod_01 {
	
	
	@Test
	public void PUTMethodDemo() {
		
		JSONObject req1 = new JSONObject();
		req1.put("name", "Jones");
		req1.put("job", "Test Lead");
		
		given().body(req1.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		// PUT request to update the record with the header
		given()
		.header("content-type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req1.toJSONString()).when()
		.put("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
		
		JSONObject req2 = new JSONObject();
		req1.put("name", "Kim Smith");
		req1.put("job", "QA Lead");
		
		// Patch Method --> Update
		
		given().body(req2.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
	
	
		// PUT request to update the record with the header
				given()
				.header("content-type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(req2.toJSONString()).when()
				.patch("https://reqres.in/api/users/2")
				.then().statusCode(200).log().all();
	
	}

}
