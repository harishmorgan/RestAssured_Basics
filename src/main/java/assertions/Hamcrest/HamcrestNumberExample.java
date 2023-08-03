package assertions.Hamcrest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.lessThan;

public class HamcrestNumberExample {
	
	public String endpoint = "https://restful-booker.herokuapp.com/booking/1";
	 
    @Test
    public void numberAssertions() {
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint).then()
                .body("totalprice", equalTo(164));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",greaterThan(100));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",greaterThanOrEqualTo(50));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",lessThan(1000));
 
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",lessThanOrEqualTo(1000));
 
    }

}
