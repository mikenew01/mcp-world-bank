package com.github.maikoncanuto.resources.handlers;

import com.github.maikoncanuto.domain.dto.ResponseApiDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.status;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        final var responseApi = new ResponseApiDTO();

        responseApi.setErro(e.getMessage());
        responseApi.setCode(valueOf(INTERNAL_SERVER_ERROR.getStatusCode()));

        return status(INTERNAL_SERVER_ERROR)
                .entity(responseApi)
                .build();
    }
}
