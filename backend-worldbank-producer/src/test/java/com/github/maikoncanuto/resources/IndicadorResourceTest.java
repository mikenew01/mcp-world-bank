package com.github.maikoncanuto.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.lang.String.valueOf;
import static org.hamcrest.CoreMatchers.*;


@QuarkusTest
public class IndicadorResourceTest {

    private static final String PATH_API = "/api/v1/indicadores/";


    @Test
    void testRetornoEndpoint() {
        given()
                .pathParam("codigoPais", "ABW")
                .queryParam("paginaAtual", 1)
                .queryParam("porPagina", 2)
                .when()
                .get(PATH_API + "{codigoPais}")
                .then()
                .statusCode(200)
                .body("code", is(valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(2))
                .body("data.paginacao", notNullValue())
                .body("data.paginacao.paginaAtual", notNullValue())
                .body("data.paginacao.paginaAtual", is(1))
                .body("data.paginacao.quantidadePaginas", notNullValue())
                .body("data.paginacao.quantidadePaginas", is(2))
                .body("data.paginacao.total", notNullValue())
                .body("data.paginacao.total", is(62))
                .body("data.paginacao.porPagina", notNullValue())
                .body("data.paginacao.porPagina", is(50))
                .body("data.indicadores[0]", notNullValue())
                .body("data.indicadores[0].dataAno", notNullValue())
                .body("data.indicadores[0].codigoPais", notNullValue())
                .body("data.indicadores[0].nomePais", notNullValue())
                .body("data.indicadores[0].indicador", notNullValue())
                .body("data.indicadores[0].codigoIndicador", notNullValue())
                .body("data.indicadores[0].dataAno", is(2020))
                .body("data.indicadores[0].codigoPais", is("ABW"))
                .body("data.indicadores[0].nomePais", is("Aruba"))
                .body("data.indicadores[0].indicador", is("Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)"))
                .body("data.indicadores[0].codigoIndicador", is("SI.POV.DDAY"));

    }

}
