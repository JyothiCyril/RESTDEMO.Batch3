package com.qa.testcode;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_POSTMethod_01 {


	@Test
	public void postMethodDemowithMap() {
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Kim Smith");
		map.put("Job", "QA Lead");
		
		System.out.println(map);
		
		JSONObject req = new JSONObject(map);
		System.out.println(req);
		

	}
	
	@Test
	public void postMethodDemowithoutMap() {
		
		JSONObject req1 = new JSONObject();
		req1.put("name", "King Blake");
		req1.put("job", "Test Lead");
		
		System.out.println(req1);
		
		given().body(req1.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
		// http status code returns "201" when a new record in created.
		
		// post with header
		given()
		.header("content-type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req1.toJSONString()).when()
		.post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
	}
}
