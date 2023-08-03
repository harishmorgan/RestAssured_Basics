package com.getCall;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Get_NonBDDDemo {
	 
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
 
    @Test
    public void verifyStatusCode() {
 
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
 
        // Create a request specification
        requestSpecification = RestAssured.given();
 
        // Calling GET method
        response = requestSpecification.get();
 
        // Let's print response body.
        String resString = response.prettyPrint();
        System.out.println("Respnse Details : " + resString);
 
        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();
 
        // Get status code
        validatableResponse.statusCode(200);
 
        // Check status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
 
        //if we don't want to use validateResponse 
        
     // Get status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
         
        // Get status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
