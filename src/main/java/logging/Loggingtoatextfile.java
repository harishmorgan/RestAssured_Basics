package logging;

import org.testng.annotations.Test;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
 

public class Loggingtoatextfile {

	@Test
    public void responsetoFileDemo() throws FileNotFoundException {
 
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
 
        String json = "{\"name\":\"apitest\",\"salary\":\"5000\",\"age\":\"30\"}";
 
        // GIVEN
        given()
               .baseUri("https://dummy.restapiexample.com/api")
               .contentType(ContentType.JSON)
                .body(json)
                .filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
 
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
