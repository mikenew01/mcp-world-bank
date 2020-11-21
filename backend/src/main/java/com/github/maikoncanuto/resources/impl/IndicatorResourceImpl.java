package com.github.maikoncanuto.resources.impl;

import com.github.maikoncanuto.resources.IIndicatorResource;
import com.github.maikoncanuto.resources.config.BaseResource;
import com.github.maikoncanuto.services.IndicatorService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;


public class IndicatorResourceImpl extends BaseResource implements IIndicatorResource {

    @Inject
    IndicatorService indicatorService;

    @Override
    @Timed(name = "timed/findIndicatorsByIdInWorldBank")
    @Counted(name = "counted/findIndicatorsByIdInWorldBank")
    public Response findIndicatorsByIdInWorldBank(final String id) {
        final var indicators = indicatorService.findIndicatorsByIdInWorldBank(id);
        return toResponse(OK, indicators);
    }
}
