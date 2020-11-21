package com.github.maikoncanuto.resources.config;

import com.github.maikoncanuto.domain.dto.ResponseApiDTO;

import javax.ws.rs.core.Response;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.Response.status;

public abstract class BaseResource {

    protected Response toResponse(final Response.Status status, final Object data) {

        final var responseApi = new ResponseApiDTO();

        responseApi.setCode(valueOf(status.getStatusCode()));
        responseApi.setData(data);

        return status(status)
                .entity(responseApi)
                .build();
    }

}
