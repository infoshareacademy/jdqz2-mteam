package com.infoshare.mteam.api;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ApiTest extends ApiUrl {

    @Test
    public void canViewHandBags() {
        when()
           .get(path("/services/public/products/page/0/30/DEFAULT/en/handbags")).
        then()
           .assertThat()
           .statusCode(200)
           .time(lessThan(2L), TimeUnit.SECONDS)
           .body("productCount", equalTo(6));
    }

    @Test
    public void canViewBags() {
        when()
           .get(path("/services/public/products/page/0/30/DEFAULT/en/bags")).
        then()
           .assertThat()
           .statusCode(200)
           .time(lessThan(1L), TimeUnit.SECONDS)
           .body("productCount", equalTo(1));
    }

    @Test
    public void canViewBeachBags() {
        when()
           .get(path("/services/public/products/page/0/30/DEFAULT/en/beachbags")).
        then()
           .assertThat()
           .statusCode(200)
           .time(lessThan(1L), TimeUnit.SECONDS)
           .body("productCount", equalTo(2));
    }

    @Test
    public void canViewLaptopBags() {
        when()
           .get(path("/services/public/products/page/0/30/DEFAULT/en/laptop-bags")).
        then()
           .assertThat()
           .statusCode(200)
           .time(lessThan(1L), TimeUnit.SECONDS)
           .body("productCount", equalTo(1));
    }
}
