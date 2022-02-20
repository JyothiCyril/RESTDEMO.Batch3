package com.qa.testcode;

import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_DDT_DELETE_01 {
	
	@Test(dataProvider="getDataforDelete")
	public void deleteRecord(int input) {
		
		when().delete("https://reqres.in/api/users/"+input).then().statusCode(204).log().all();
		
	}
	
	
	@DataProvider
	public Object[] getDataforDelete() {
		
		return new Object[] {
				2,3,4
		};
	}

}
