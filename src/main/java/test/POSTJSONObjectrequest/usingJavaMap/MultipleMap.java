package test.POSTJSONObjectrequest.usingJavaMap;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import java. util.*;

public class MultipleMap {
	
	@Test
    public void passBodyAsMultipleMap() {
        // First JSON Object using Hash Map
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("employee_name", "MapTest");
        data.put("profile_image", "test.png");
        // Second JSON Object using Hash Map
        Map<String, String> msg = new HashMap<String, String>();
        msg.put("updated_message", "Details of New Resource");
        msg.put("employee_age", "30");
        data.put("details", msg);
        data.put("employee_salary", "99999");
        RestAssured.given().contentType(ContentType.JSON).body(data).log().all()
                // WHEN
                .when().post("http://dummy.restapiexample.com/api/v1/create")
                // THEN
                .then().assertThat().statusCode(200).body("data.employee_name", equalTo("MapTest"))
                .body("data.details.updated_message", equalTo("Details of New Resource"))
                .body("data.details.employee_age", equalTo("30")).body("data.employee_salary", equalTo("99999"))
                .body("message", equalTo("Successfully! Record has been added.")).log().all();
    }
}


