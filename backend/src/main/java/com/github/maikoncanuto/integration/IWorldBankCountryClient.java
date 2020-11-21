package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.ResponseCountryDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("v2/country")
@ApplicationScoped
@Produces(APPLICATION_JSON)
@RegisterRestClient
public interface IWorldBankCountryClient {

    @GET
    ResponseCountryDTO getCountries(@QueryParam("format") String format);

}
