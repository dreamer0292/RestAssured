package demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostMethodwithBody {

	public String accessToken; 
	public String id;
	@Test(enabled=false)
	public void testcase1()
	{
		//first step
        RestAssured.baseURI ="https://ecommerceservice.herokuapp.com";
        System.out.println("started");
        given()
        .header("content-Type","application/json")
        .body("{\r\n" + 
                "    \"email\": \"rsangi@gmail.com\",\r\n" + 
                "    \"password\": \"suniltrng1@123\"\r\n" + 
                "}\r\n" + 
                "")
        
        .when()
        .post("/user/signup")
        
        .then()
        .assertThat().statusCode(201).and()
        .contentType(ContentType.JSON);
        System.out.println("Ended");
	}
	
	@Test(priority=0)
	public void Login()
	{
		//first step
		String requestBody="{\r\n" + 
                "    \"email\": \"rsangi@gmail.com\",\r\n" + 
                "    \"password\": \"suniltrng1@123\"\r\n" + 
                "}\r\n" + 
                "";
				RestAssured.baseURI ="https://ecommerceservice.herokuapp.com";
        System.out.println("started");
    Response response=    given()
        .header("content-Type","application/json")
        .body(requestBody)
        
        .when()
        .post("/user/Login")
        
        .then()
        .assertThat().statusCode(200).and()
        .contentType(ContentType.JSON).extract().response();
        System.out.println("Ended");
        String jsonresp=response.asString();
        JsonPath responseBody=new JsonPath(jsonresp);
        accessToken=responseBody.getString("accessToken");
        System.out.println("access token is :  "+accessToken);
	}
	
	@Test(priority=1)
	public void getUser()
	{
		RestAssured.baseURI ="https://ecommerceservice.herokuapp.com";
		Response response=    given()
		        .header("content-Type","application/json")
		        .header("Authorization", "bearer " + accessToken)
		        .when()
		        .get("/user")
		        .then()
		        .assertThat().statusCode(200).and()
		        .contentType(ContentType.JSON).extract().response();	
		 String jsonresp=response.asString();
	        JsonPath responseBody=new JsonPath(jsonresp);
	        id=responseBody.get("users[2]._id");
	        System.out.println("user id is"+ id);
	}

	@Test(priority=2)
	public void Delete()
	{
		RestAssured.baseURI ="https://ecommerceservice.herokuapp.com";
		Response response=    given()
		        .header("content-Type","application/json")
		        .header("Authorization", "bearer " + accessToken)
		        .when()
		        .delete("/user/"+id)
		        .then()
		        .assertThat().statusCode(200).and()
		        .contentType(ContentType.JSON).extract().response();	
		 String jsonresp=response.asString();
	        JsonPath responseBody=new JsonPath(jsonresp);
	String message=responseBody.get("message");
	System.out.println(message);
	
	}

}
