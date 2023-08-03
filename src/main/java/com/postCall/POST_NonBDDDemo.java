package com.postCall;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class POST_NonBDDDemo {
	 
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
 
    @Test
    public void verifyStatusCode() {
 
        String jsonString = "{\"name\":\"newapitest\",\"salary\":\"4000\",\"age\":\"29\"}";
 
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
 
        // Create a request specification
        requestSpecification = RestAssured.given();
 
        // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);
 
        // Adding body as string
        requestSpecification.body(jsonString);
 
        // Calling POST method
        response = requestSpecification.post();
 
        // Let's print response body.
        String responseString = response.prettyPrint();
 
        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();
 
        // Check status code
        validatableResponse.statusCode(200);
 
        // It will check if status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
 
        // Check response body - name attribute
        validatableResponse.body("data.name", equalTo("newapitest"));
 
        // Check response body - message attribute
        validatableResponse.body("message", equalTo("Successfully! Record has been added."));
 
    }

}
