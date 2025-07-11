import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteTest {
    @Test
    void testDeleteMethod() {
        given().log().all()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")

                .when().delete("/delete")

                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .contentType(ContentType.JSON);
    }
}