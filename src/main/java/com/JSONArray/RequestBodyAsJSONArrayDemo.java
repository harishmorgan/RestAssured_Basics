package com.JSONArray;


import org.json.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestBodyAsJSONArrayDemo {
	
	@Test
    public void passBodyAsJsonArrayDemo() {
 
        // JSON Object for first employee
        JSONObject data1 = new JSONObject();
 
        data1.put("employee_name", "ObjectTest");
        data1.put("profile_image", "test1.png");
        data1.put("employee_age", "30");
        data1.put("employee_salary", "11111");
 
        // JSON Object for second employee
        JSONObject data2 = new JSONObject();
 
        data2.put("employee_name", "MapTest");
        data2.put("profile_image", "test2.png");
        data2.put("employee_age", "20");
        data2.put("employee_salary", "99999");
 
        // Creating JSON array to add both JSON objects
        JSONArray array = new JSONArray();
        array.put(data1);
        array.put(data2);
 
        // Send the request     
        RestAssured.given()
                          .contentType(ContentType.JSON)
                          .body(array.toString())
                          .log().all()
                 
                .when()
                       .post("http://dummy.restapiexample.com/api/v1/create")
                 
                .then()
                      .assertThat().statusCode(200)
                      .body("message", equalTo("Successfully! Record has been added."))
                      .log().all();
    }

}
