package logging;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ConditionalLogging {
	@Test
    public void conditionalResponseLoggingDemo() {
 
        String json = "{\"name\":\"apitest\",\"salary\":\"5000\",\"age\":\"30\"}";
 
        // GIVEN
        given()
               .baseUri("https://dummy.restapiexample.com/api")
               .contentType(ContentType.JSON)
               .body(json)
 
        // WHEN
         .when()
               .post("/v1/create")
 
        // THEN
         .then()
                .log().ifStatusCodeIsEqualTo(200)
                .assertThat().statusCode(200)
                .body("data.name", equalTo("apitest"))
                .body("message", equalTo("Successfully! Record has been added."));
 
    }

}
