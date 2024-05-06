package com.simpletests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Tests_testng {
	
	@BeforeMethod
	public void setUp() {
	
		RestAssured.baseURI = "https://reqres.in";  //static property
		RestAssured.basePath = "/api";
		
	}
	
  @Test
  public Response listUser() {
	return  given().when().get("/users/2").then().assertThat().statusCode(200).and()
	  .extract().response(); 

  }
  
  @AfterMethod
  public void tearDown() {
	  
	  System.out.println(listUser().asString());
  }
  /*
   * this method returns response
   *  
   */

 // @Test
  public void listUsers() {
	 Response response = given()
			 .param("page", "2")
			 .when().get("/users").then().assertThat().statusCode(200).and()
	  .extract().response(); 
	 response.prettyPrint();
  }
  
  /** verify that empty response is received
   *
   */
  //@Test
  public void UserNotFound() {
	  
	//  https://reqres.in/api/users/23
	   given().when().get("/users/23").then().assertThat().body(equalTo("{}")); 
	   
  }
  
  
  //@Test
  public void UserNotFound2() {
	  
	//  https://reqres.in/api/users/23
	   given().when().get("/users/23").then().assertThat().body(containsString("")); 
	   
  }
  
  //@Test
  public void loginUnsuccessful1() {
	  
	  
	 given().when().body("{\n"
	  		+ "    \"email\": \"peter@klaven\"\n"
	  		+ "}").post("/login").then().assertThat().body(containsString("error"));	 
	 
  }
  
  

  //@Test
  public void loginUnsuccessful2() {
	  
	  String expectedmsg = "Missing email or username";
	Response response =  given().when().body("{\n"
	  		+ "    \"email\": \"peter@klaven\"\n"
	  		+ "}").post("/login");
			
		String errorMessage = response.then().assertThat().extract().path("error") ;
		Assert.assertEquals(errorMessage, expectedmsg);
		
	 
  }
//@Test
public void delayResponse() {
	
	 given()
			 .param("delay", "3")
			 .when().get("/users").then().time(lessThan(10L),TimeUnit.SECONDS);
	 
}




}

