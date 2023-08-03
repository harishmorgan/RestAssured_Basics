package test.POSTrequest.fromJSONObject;

import org.testng.annotations.Test;
import org.json.JSONObject;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPOSTrequestFromJSONObjectInRestAssured {
	
	@Test
	public void passBodyAsJsonObject() {
	 
	  JSONObject data = new JSONObject();
	 
	  data.put("employee_name", "MapTest");
	  data.put("profile_image", "test.png");
	  data.put("employee_age", "30");
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
	               .body("data.employee_age", equalTo("30"))
	               .body("data.employee_salary", equalTo("11111"))
	               .body("data.profile_image", equalTo("test.png"))
	               .body("message", equalTo("Successfully! Record has been added."))
	               .log().all();
	 
	    }

}
