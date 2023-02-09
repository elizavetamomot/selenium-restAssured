package api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter3Test {

    public static Object[][] zipCodesAndPlaces() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @ParameterizedTest
    @MethodSource("zipCodesAndPlaces")
    public void requestZipCodeFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(
            String countryCode, String zipCode, String expectedPlaceName
    ){

        given()
                .pathParam("countryCode", countryCode).pathParam("zipCode", zipCode)
                .when()
                .get("http://api.zippopotam.us/{countryCode}/{zipCode}")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo(expectedPlaceName));
    }
}
