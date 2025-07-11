import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutTest {
    @Test
    void testPutMethod() {
        given().log().all().baseUri("https://postman-echo.com")
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")

                .when().put("/put")

                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .contentType(ContentType.JSON);
    }
}
