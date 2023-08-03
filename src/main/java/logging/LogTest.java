package logging;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
 
public class LogTest {
     
     public PrintStream log ;
     RequestLoggingFilter requestLoggingFilter;
     ResponseLoggingFilter responseLoggingFilter;
     
    @BeforeClass
    public void init() throws FileNotFoundException {
         
         log = new PrintStream(new FileOutputStream("test_logging.txt"),true);  
         requestLoggingFilter = new RequestLoggingFilter(log);
         responseLoggingFilter = new ResponseLoggingFilter(log);
          
    }
     
    @Test
    public void test1() {
 
        // Given
        given()
 
         .contentType(ContentType.JSON)
         . filters(requestLoggingFilter,responseLoggingFilter)
        
          .when()
             .get("https://dummy.restapiexample.com/api/v1/employee/2")
                 
           .then()
                .log().ifStatusCodeIsEqualTo(200)
                .assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                 
                // To verify booking id at index 2
                .body("data.employee_name", equalTo("Garrett Winters"))
                .body("message", equalTo("Successfully! Record has been fetched."));
    }
     
    @Test
    public void test2() {
 
        // Given
        given()
 
         .contentType(ContentType.JSON)
         . filters(requestLoggingFilter,responseLoggingFilter)
        
          .when()
             .get("https://dummy.restapiexample.com/api/v1/employee/1")
                 
           .then()
           .log().ifStatusCodeIsEqualTo(200)
           .assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                // To verify booking id at index 1
                .body("data.employee_name", equalTo("Tiger Nixon"))
                .body("message", equalTo("Successfully! Record has been fetched."));
    }
 
     
     
    @Test
    public void test3() throws FileNotFoundException {
  
         
        String json = "{\"name\":\"apitest\",\"salary\":\"5000\",\"age\":\"30\"}";
  
        // GIVEN
        given()
               .baseUri("https://dummy.restapiexample.com/api")
               .contentType(ContentType.JSON)
                .body(json)
               .filters(requestLoggingFilter,responseLoggingFilter)
  
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
