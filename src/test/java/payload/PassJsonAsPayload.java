package payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PassJsonAsPayload {
	
	ValidatableResponse validatableResponse;
	 
    @Test
    public void createUser() {
 
        // Creating a File instance
        File jsonData = new File("src/test/resources/payload/books.json");
 
        // GIVEN
        given()
               .baseUri("http://dummy.restapiexample.com/api")
               .contentType(ContentType.JSON)
               .body(jsonData)
 
        // WHEN
        .when()
              .post("/v1/create")
 
        // THEN
        .then()
               .assertThat()
               .statusCode(200)
               .body("data.name", equalTo("Json_Test"))
               .body("message", equalTo("Successfully! Record has been added."))
               .log().all();
 
    }

}
