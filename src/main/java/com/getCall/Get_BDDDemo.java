package com.getCall;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Get_BDDDemo {
	
	@Test
    public void verifyUser() {
 
        // Given
        given()
         
        // When
        .when()
              .get("http://dummy.restapiexample.com/api/v1/employee/2")
                 
         // Then
        .then()
              .statusCode(200).statusLine("HTTP/1.1 200 OK")
                 
         // To verify booking id at index 3
              .body("data.employee_name", equalTo("Garrett Winters"))
              .body("message", equalTo("Successfully! Record has been fetched."));
    }

}
