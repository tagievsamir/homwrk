import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostTest {

    RequestSpecification spec;

    @BeforeEach
    void setUp() {
        spec = RestAssured.given()
                .baseUri("https://postman-echo.com")
                .log().all();
    }

    @Test
    void testPostRawText() {
        spec
                .contentType("application/json; charset=utf-8")
                .body("{\"test\" : \"value\"}")

                .when().post("/post")

                .then().log().all()
                .statusCode(200)
                .body("data.test", equalTo("value"))
                .contentType("application/json; charset=utf-8");
    }

    @Test
    void testPostFormData() {
        spec
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .contentType("application/json; charset=utf-8");
    }
}
