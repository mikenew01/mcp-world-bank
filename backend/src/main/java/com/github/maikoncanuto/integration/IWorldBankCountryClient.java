package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.ResponseCountryDTO;
import com.github.maikoncanuto.domain.dto.ResponseIndicatorDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("v2/country")
@ApplicationScoped
@Produces(APPLICATION_JSON)
@RegisterRestClient
public interface IWorldBankCountryClient {

    @GET
    ResponseCountryDTO getCountries(@QueryParam("format") String format);

    @GET
    @Path("/{id}/indicator/SI.POV.DDAY")
    ResponseIndicatorDTO getIndicators(@PathParam("id") String id, @QueryParam("format") String format);

}
