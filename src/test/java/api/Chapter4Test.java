package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter4Test {

    public static RequestSpecification requestSpec;

    @BeforeAll
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us")
                .build();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){

        given()
                .spec(requestSpec)
                .when()
                .get("us/90210")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    private static ResponseSpecification responseSpec;

    @BeforeAll
    public static void createResponseSpecification(){

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void requestUsZipCode90210_checkStatusAndContentTypeInResponseBody_expect200JSON(){

        given()
                .spec(requestSpec)
                .when()
                .get("us/90210")
                .then()
                .spec(responseSpec)
                .and()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_extractPlaceNameFromResponseBody_expectBeverlyHills(){

        String placeName =

                given()
                        .spec(requestSpec)
                        .when()
                        .get("us/90210")
                        .then()
                        .extract()
                        .path("places[0].'place name'");

        Assertions.assertEquals("Beverly Hills", placeName);
    }
}