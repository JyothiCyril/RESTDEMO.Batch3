package com.qa.testcode;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_GETMethod_02 {
	
	
	@Test
	public void getMethodDemo() {
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		
		// Auto-assertion using Given, when then format..
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7))
		//.body("data.first_name", hasItems("Lindsay","Michael","Smith"))
		.log().all();
		
		
		// checking if the id value at the index position 0 is 7 or not...
		// data --> root element. id --> attribute ,, [0] --> Index position where item 7 is stored.
		
		// log().all() --> print the log status into the console
		
		
	}

}
