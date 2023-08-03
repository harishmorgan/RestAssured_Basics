package test.POSTJSONObjectrequest.usingJavaMap;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import java. util.*;
public class JavamapSingle {
	
	@Test
	public void passBodyAsMap() {
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("employee_name", "MapTest");
	    map.put("employee_salary", "99999");
	    map.put("employee_age", "30");
	    map.put("profile_image", "test.png");
	    RestAssured.given()
	                      .contentType(ContentType.JSON)
	                      .body(map)
	                      .log().all()
	             
	               .when()
	                     .post("http://dummy.restapiexample.com/api/v1/create")
	             
	               .then()
	                     .assertThat().statusCode(200)
	                     .body("data.employee_name", equalTo("MapTest"))
	                     .body("data.employee_age", equalTo("30"))
	                     .body("data.employee_salary", equalTo("99999"))
	                     .body("message", equalTo("Successfully! Record has been added.")).log().all();
	}

}
