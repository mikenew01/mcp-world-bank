package com.github.maikoncanuto.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
class PaisResurceTest {

    private static final String PATH_API = "/api/v1/paises";

    @Test
    void testRetornoEndpointFindAllPaises() {

        given()
                .when()
                .get(PATH_API)
                .then()
                .statusCode(200)
                .body("code", is(String.valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(2))
                .body("data.paginacao", notNullValue())
                .body("data.paginacao.paginaAtual", notNullValue())
                .body("data.paginacao.paginaAtual", is(1))
                .body("data.paginacao.quantidadePaginas", notNullValue())
                .body("data.paginacao.quantidadePaginas", is(7))
                .body("data.paginacao.total", notNullValue())
                .body("data.paginacao.total", is(304))
                .body("data.paginacao.porPagina", notNullValue())
                .body("data.paginacao.porPagina", is(50))
                .body("data.paises[0]", notNullValue())
                .body("data.paises[0].codigoPais", notNullValue())
                .body("data.paises[0].codigoPais", is("ABW"))
                .body("data.paises[0].nome", notNullValue())
                .body("data.paises[0].nome", is("Aruba"))
                .body("data.paises[0].capital", notNullValue())
                .body("data.paises[0].capital", is("Oranjestad"));

    }


}
