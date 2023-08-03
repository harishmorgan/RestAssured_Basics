package com.deleteCall;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class Delete_NonBddDemo {

	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
 
    @Test
    public void deleteUser() {
 
        RestAssured.baseURI = "http://dummy.restapiexample.com/api";
 
        // Create a request specification
        requestSpecification = RestAssured.given();
 
        // Calling DELETE method
        response = requestSpecification.delete("/v1/delete/3");
 
        // Let's print response body.
        String resString = response.prettyPrint();
 
        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();
 
        // Get status code
        validatableResponse.statusCode(200);
 
        // It will check if status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
 
        // Check response - message attribute
        validatableResponse.body("message", equalTo("Successfully! Record has been deleted"));
 
    }
}
