package assertions.Hamcrest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class HamcrestStringAssertions {
	
	public String endpoint = "https://restful-booker.herokuapp.com/booking/1";
	 
    @SuppressWarnings("deprecation")
	@Test
    public void stringAssertions() {
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalTo("Mary"));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalToIgnoringCase("mary"));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",containsString("Mary"));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",startsWith("M"));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",endsWith("y"));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalToCompressingWhiteSpace("   Mary "));
 
 
    }

}
