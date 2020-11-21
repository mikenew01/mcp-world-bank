package com.github.maikoncanuto.resources;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/paises")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Tag(name = "Paises", description = "Endpoints para acessar informações de paises na base dados do World Bank")
public interface IPaisResource {

    @GET
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informações de paises na base de dados do World Bank",
            operationId = "countries#findCountriesInWorldBank",
            summary = "Buscar informações de paises"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    Response findCountriesInWorldBank(@QueryParam("paginaAtual") final Integer paginaAtual,
                                      @DefaultValue("50") @QueryParam("porPagina") final Integer porPagina);

}
