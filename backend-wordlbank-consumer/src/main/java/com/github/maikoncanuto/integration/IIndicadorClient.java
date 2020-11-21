package com.github.maikoncanuto.integration;


import com.github.maikoncanuto.domain.dto.ResponseApiDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("indicadores")
@ApplicationScoped
@Produces(APPLICATION_JSON)
@RegisterRestClient
public interface IIndicadorClient {

    @GET
    @Path("/{codigoPais}")
    ResponseApiDTO getIndicadores(@PathParam("codigoPais") final String codigoPais,
                                  @QueryParam("porPagina") final Integer porPagina,
                                  @QueryParam("paginaAtual") final Integer paginaAtual);

}
