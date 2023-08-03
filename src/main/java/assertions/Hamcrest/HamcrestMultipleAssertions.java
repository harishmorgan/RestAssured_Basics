package assertions.Hamcrest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
 
public class HamcrestMultipleAssertions {
 
    public String endpoint = "https://restful-booker.herokuapp.com/booking/1";
     
    @Test
    public void test1() {
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint).then()
                .body("firstname", equalTo("Jim"), // will fail
                        "lastname", equalTo("Smith"), // will fail
                        "totalprice", equalTo(314)); // will fail
    }
    
    @Test
    public void test() {
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint).then()
                .body("firstname", equalTo("Jim"), // will fail
                        "lastname", equalTo("Smith"), // will fail
                        "totalprice", equalTo(314)); // will fail
    }
 
}
