package com.qa.testcode;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_DDT_POST_01 {

	@Test(dataProvider="getDataforPost")
	public void PostRecord(String name, String job) {
		
		JSONObject req = new JSONObject();
		req.put("Name", name);
		req.put("Job", job);
		
		/*
		 * given().body(req.toJSONString()).when().post("https://reqres.in/api/users")
		 * .then().statusCode(201).log().all();
		 */
		
		given()
		.header("content-type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString()).when()
		.post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
	}
	
	
	@DataProvider
	public Object[][] getDataforPost(){
		
		return new Object[][] {
			{"Smith","Test lead"},
			{"Blake","QA Lead"},
			{"Roger","QA Engineer"}
		};
	}
	
	
	
}
