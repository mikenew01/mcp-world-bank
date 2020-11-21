package com.github.maikoncanuto.resources.impl;

import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.resources.IPaisResource;
import com.github.maikoncanuto.resources.config.BaseResource;
import com.github.maikoncanuto.services.PaisService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

public class PaisResourceImpl extends BaseResource implements IPaisResource {

    @Inject
    PaisService paisService;

    @Override
    @Timed(name = "timed/findAll#pais")
    @Counted(name = "counted/findAll#pais")
    public Response findAll(final Integer paginaAtual, final Integer porPagina) {

        final var paginacaoDTO = new PaginacaoDTO();
        paginacaoDTO.setPaginaAtual(paginaAtual);
        paginacaoDTO.setPorPagina(porPagina);

        final var paises = paisService.findAll(paginacaoDTO);
        return toResponse(OK, paises);
    }
}
