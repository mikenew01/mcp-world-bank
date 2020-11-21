package com.github.maikoncanuto.resources.impl;

import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.resources.IIndicadorResource;
import com.github.maikoncanuto.resources.config.BaseResource;
import com.github.maikoncanuto.services.IndicadorService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;


public class IndicadorResourceImpl extends BaseResource implements IIndicadorResource {

    @Inject
    IndicadorService indicadorService;

    @Override
    @Timed(name = "timed/findIndicatorsByIdInWorldBank")
    @Counted(name = "counted/findIndicatorsByIdInWorldBank")
    public Response findIndicatorsByIdInWorldBank(final String id, final Integer paginaAtual, final Integer porPagina) {
        final var paginacao = new PaginacaoDTO();
        paginacao.setPorPagina(porPagina);
        paginacao.setPaginaAtual(paginaAtual);

        final var indicators = indicadorService.findIndicatorsByIdInWorldBank(id, paginacao);
        return toResponse(OK, indicators);
    }
}
