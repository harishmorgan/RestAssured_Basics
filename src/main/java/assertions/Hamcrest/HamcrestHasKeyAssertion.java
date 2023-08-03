package assertions.Hamcrest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.hasKey;
 
public class HamcrestHasKeyAssertion {
     
    public String endpoint = "https://restful-booker.herokuapp.com/booking/1";
 
    @Test
    public void collectionAssertions() {
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("bookingdates",hasKey("checkin"));
 
    }
}