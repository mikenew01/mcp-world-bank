package com.github.maikoncanuto.resources;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/indicadores")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Tag(name = "Indicadores", description = "Endpoints para acessar informações de indicadores na base dados do World Bank")
public interface IIndicadorResource {

    @GET
    @Path("/{codigoPais}")
    @Timeout
    @Retry
    @Operation(
            description = "Buscar informações de indicadores de paises na base de dados do World Bank",
            operationId = "countries#findIndicatorsByIdInWorldBank",
            summary = "Buscar informações de indicadores por código pais"
    )
    @APIResponse(name = "OK", responseCode = "200", description = "Requisição completada com sucesso")
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Ocorreu um problema interno no servidor")
    Response findIndicatorsByIdInWorldBank(@PathParam("codigoPais") @NotNull final String codigoPais,
                                           @QueryParam("paginaAtual") final Integer paginaAtual,
                                           @DefaultValue("50") @QueryParam("porPagina") final Integer porPagina);

}
