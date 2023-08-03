package test.POSTrequest.fromJSONObject;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class TwoJsonObjects {

	
	@Test
	public void passBodyAsJsonObjectDemo() {
	         
	   //First JSONObject
	    JSONObject data = new JSONObject();
	 
	    data.put("profile_image", "test.png");
	         
	    //Second JSONObject
	    JSONObject detail = new JSONObject();
	 
	    detail.put("updated_message", "Details of New Resource");
	    detail.put("employee_age", "30");
	 
	    data.put("employee_details", detail);
	 
	    data.put("employee_name", "MapTest");
	    data.put("employee_salary", "11111");
	     
	    RestAssured
	        .given()
	               .contentType(ContentType.JSON)
	               .body(data.toString())
	               .log().all()
	                 
	        .when()
	              .post("http://dummy.restapiexample.com/api/v1/create")
	                 
	        .then()
	               .assertThat().statusCode(200)
	               .body("data.employee_name", equalTo("MapTest"))
	               .body("data.employee_details.employee_age", equalTo("30"))
	               .body("data.employee_details.updated_message", equalTo("Details of New Resource"))
	               .body("data.employee_salary", equalTo("11111")).body("data.profile_image", equalTo("test.png"))
	                .body("message", equalTo("Successfully! Record has been added."))
	                .log().all();
	    }
}
