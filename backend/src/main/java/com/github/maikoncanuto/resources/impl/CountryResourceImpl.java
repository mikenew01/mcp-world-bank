package com.github.maikoncanuto.resources.impl;

import com.github.maikoncanuto.resources.ICountryResource;
import com.github.maikoncanuto.resources.config.BaseResource;
import com.github.maikoncanuto.services.CountryService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

public class CountryResourceImpl extends BaseResource implements ICountryResource {

    @Inject
    CountryService countryService;

    @Override
    @Timed(name = "timed/findCountriesInWorldBank")
    @Counted(name = "counted/findCountriesInWorldBank")
    public Response findCountriesInWorldBank() {
        final var countries = countryService.findCountriesInWorldBank();
        return toResponse(OK, countries);
    }
}
