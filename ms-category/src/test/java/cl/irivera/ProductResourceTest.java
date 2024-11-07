package cl.irivera;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProductResourceTest {
    /*@Test
    void testStatus() {
        given()
          .when().get("/api/product/status")
          .then()
             .statusCode(200)
             .body(is("OK"));
    }*/

}