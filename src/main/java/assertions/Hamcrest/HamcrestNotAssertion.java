package assertions.Hamcrest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
 
public class HamcrestNotAssertion {
     
    public String endpoint = "https://restful-booker.herokuapp.com/booking/1";
 
    @Test
    public void negativeAssertions() {
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",not(equalTo(874)));
 
    }
}
