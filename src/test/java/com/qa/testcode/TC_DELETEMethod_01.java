package com.qa.testcode;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TC_DELETEMethod_01 {
	
	
	@Test
	public void DeleteDemo() {
		
		
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		
		
		
	}

}
