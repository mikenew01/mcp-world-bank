package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.ResponseApiDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("paises")
@ApplicationScoped
@Produces(APPLICATION_JSON)
@RegisterRestClient
public interface IPaisClient {

    @GET
    ResponseApiDTO getPaises(@QueryParam("porPagina") final Integer porPagina,
                             @QueryParam("paginaAtual") final Integer paginaAtual);
}
