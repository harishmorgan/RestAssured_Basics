package com.putCall;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PUT_BDDDemo {

	ValidatableResponse validatableResponse;
	ValidatableResponse validatableResponse1;
	
	@Test
    public void updateUser() {
 
    // To get the detail of employee with id 2
    validatableResponse = given()
                              .baseUri("http://dummy.restapiexample.com/api/v1/employee/2")
                              .contentType(ContentType.JSON)
                          .when()
                               .get()
                          .then()
                               .assertThat().statusCode(200);
 
        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
 
        String jsonString = "{\"id\": 2,\r\n"
                  + "        \"employee_name\": \"Garrett Winters\",\r\n"
                  + "        \"employee_salary\": 99999,\r\n"
                  + "        \"employee_age\": 63,\r\n"
                  + "        \"profile_image\": \"\"}";
 
    // Update employee_salary
    validatableResponse1 = given()
                               .baseUri("http://dummy.restapiexample.com/api/v1/update/2")
                               .contentType(ContentType.JSON)
                               .body(jsonString)
                           .when()
                               .put()
                           .then()
                               .assertThat().statusCode(200)
                              .body("data.employee_salary", equalTo(99999))
                              .body("message", equalTo("Successfully! Record has been updated."));
         
       System.out.println("Response :" + validatableResponse1.extract().asPrettyString());
 
    }
 
}
