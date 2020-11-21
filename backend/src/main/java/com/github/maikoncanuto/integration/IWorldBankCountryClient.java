package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.worldbank.country.ResponseCountryWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.ResponseIndicatorWorldBankDTO;
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
    ResponseCountryWorldBankDTO getCountries(@DefaultValue("json") @QueryParam("format") String format,
                                             @DefaultValue("50") @QueryParam("per_page") final String perPage,
                                             @QueryParam("page") final Integer page);

    @GET
    @Path("/{id}/indicator/SI.POV.DDAY")
    ResponseIndicatorWorldBankDTO getIndicators(@PathParam("id") final String id,
                                                @DefaultValue("json") @QueryParam("format") final String format,
                                                @QueryParam("page") final Integer page,
                                                @QueryParam("per_page") final Integer perPage);

}
