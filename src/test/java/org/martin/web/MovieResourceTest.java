package org.martin.web;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class MovieResourceTest {

    @Test
    void shouldGetAllMovies() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/api/movies")
                .then()
                .statusCode(Status.OK.getStatusCode())
                .body("size()", is(3));
    }

    @Test
    void shouldGetAMovie(){
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 100)
                .when().get("/api/movies/{id}")
                .then()
                .statusCode(Status.OK.getStatusCode())
                .body("title", is("Interstellar"))
                .body("description", is("A team of explorers travel through a wormhole in space in an attempt to ensure humanitys survival"))
                .body("director", is("Christopher Nolan"));

    }
}