package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class BookingExtration {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking/15")
                .then().statusCode(200);
    }

    @Test
    public void tesNo01() {
        response.body(".", hasKey("firstname"));
    }

    @Test
    public void testNo02() {
        response.body(".", hasKey("lastname"));
    }

    @Test
    public void testNo03() {
        response.body(".", hasKey("totalprice"));
    }

    @Test
    public void testNo04() {
        response.extract().path("firstname");
    }

    @Test
    public void testNo05() {
        response.body("bookingdates", hasKey("checkin"));
    }

    @Test
    public void testNo06() {
        response.body("additionalneeds", equalTo("Breakfast"));
    }

    @Test
    public void testNo07() {
        response.body(".", hasKey("bookingdates"));
    }
}
