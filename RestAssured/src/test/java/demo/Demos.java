package demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
public class Demos {

//I have to provide the base url
	public static String baseUrl="https://api.trello.com";
	//public static void main(String[]args)
	@Test
	public void testCase1()
	{
		//in rest assured I have to use rest assured method
		
		RestAssured.baseURI=baseUrl;// method to undertand tat this is the base url I have to work on
		//given: required parameters,key,token
		//when: it is a condition what is required to run on url, what resource is required
		//then : is all about post condition
		//given is a precondition which will take ur key,parameters, hearders(authorization)
		given().
		param("key", "f138d60ababa77cfab0682b16c99fe38").
		param("token", "a6981c0bf874d020c877d60c0b6842b8629ed75b26596ddd186437a469ca3a6d").
		//when is used to give methods like get//post//put//delete, can also contain body if required
		when().
		get("/1/boards/0myqth3n").
		then().
		assertThat().statusCode(200).contentType(ContentType.JSON).and().
		body("name", equalTo("Rashmi's Board")).and().
		 body("desc",equalTo("This is SDET training , working on rest assured"));
        System.out.println("This first method executed successfully");
}
	@Test
	public void testCase2()
	{
		//in rest assured I have to use rest assured method
		
		RestAssured.baseURI=baseUrl;// method to undertand tat this is the base url I have to work on
		//given: required parameters,key,token
		//when: it is a condition what is required to run on url, what resource is required
		//then : is all about post condition
		//given is a precondition which will take ur key,parameters, hearders(authorization)
		given().
		param("key", "f138d60ababa77cfab0682b16c99fe38").
		param("token", "a6981c0bf874d020c877d60c0b6842b8629ed75b26596ddd186437a469ca3a6d").
		//when is used to give methods like get//post//put//delete, can also contain body if required
		when().
		get("/1/boards/0myqth3n").
		then().
		assertThat().statusCode(200).contentType(ContentType.JSON).and().
		header("Expires", equalTo("Thu, 01 Jan 1970 00:00:00"));
		
        System.out.println("The second method successfully");
}
	
	@Test
	public void testCase3()
	{
		//in rest assured I have to use rest assured method
		
		RestAssured.baseURI=baseUrl;// method to undertand tat this is the base url I have to work on
		//given: required parameters,key,token
		//when: it is a condition what is required to run on url, what resource is required
		//then : is all about post condition
		//given is a precondition which will take ur key,parameters, hearders(authorization)
		given().
		param("key", "f138d60ababa77cfab0682b16c99fe38").
		param("token", "a6981c0bf874d020c877d60c0b6842b8629ed75b26596ddd186437a469ca3a6d").
		//when is used to give methods like get//post//put//delete, can also contain body if required
		when().
		get("/1/boards/0myqth3n").
		then().
		assertThat().statusCode(200).contentType(ContentType.JSON).and().
		body("name", equalTo("Rashmi's Board")).and().
		 body("desc",equalTo("This is SDET training , working on rest assured"));
        System.out.println("This first method executed successfully");
}
}