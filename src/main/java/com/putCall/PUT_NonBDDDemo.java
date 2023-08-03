package com.putCall;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class PUT_NonBDDDemo {
	
	 RequestSpecification requestSpecification;
	    Response response;
	    ValidatableResponse validatableResponse;
	 
	    @Test
	    public void updateUser() {
	 
	        String jsonString = "{\"id\": 2,\r\n"
	                          + "        \"employee_name\": \"Garrett Winters\",\r\n"
	                          + "        \"employee_salary\": 99999,\r\n"
	                          + "        \"employee_age\": 63,\r\n"
	                          + "        \"profile_image\": \"\"}";
	 
	        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update/2";
	 
	        // Create a request specification
	        requestSpecification = RestAssured.given();
	 
	        // Setting content type to specify format in which request payload will be sent.
	        requestSpecification.contentType(ContentType.JSON);
	 
	        // Adding body as string
	        requestSpecification.body(jsonString);
	 
	        // Calling PUT method
	        response = requestSpecification.put();
	 
	        // Let's print response body.
	        String responseString = response.prettyPrint();
	 
	        /*
	         * To perform validation on response, we need to get ValidatableResponse type of
	         * response
	         */
	        validatableResponse = response.then();
	 
	        // Get status code
	        validatableResponse.statusCode(200);
	 
	        // It will check if status line is as expected
	        validatableResponse.statusLine("HTTP/1.1 200 OK");
	 
	        // Check response - name attribute
	        validatableResponse.body("data.employee_salary", equalTo(99999));
	 
	        // Check response - message attribute
	        validatableResponse.body("message", equalTo("Successfully! Record has been updated."));
	 
	    }

}
