package com.postCall;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POST_BDDDemo {
	
	ValidatableResponse validatableResponse;
	 
    @Test
    public void createUser() {
 
        String json = "{\"name\":\"apitest\",\"salary\":\"5000\",\"age\":\"30\"}";
 
        // GIVEN
        validatableResponse = given()
                .baseUri("http://dummy.restapiexample.com/api")
                .contentType(ContentType.JSON)
                .body(json)
                 
                // WHEN
                .when()
                     .post("/v1/create")
                      
                // THEN
                .then()
                      .assertThat().statusCode(200).body("data.name", equalTo("apitest"))
                      .body("message", equalTo("Successfully! Record has been added."));
         
        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }

}
