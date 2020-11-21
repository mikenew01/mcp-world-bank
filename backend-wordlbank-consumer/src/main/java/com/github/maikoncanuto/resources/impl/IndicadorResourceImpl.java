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
    @Timed(name = "timed/findIndicadorByCodigoPais")
    @Counted(name = "counted/findIndicadorByCodigoPais")
    public Response findIndicadorByCodigoPais(final String codigoPais, final Integer paginaAtual, final Integer porPagina) {
        final var paginacao = new PaginacaoDTO();
        paginacao.setPorPagina(porPagina);
        paginacao.setPaginaAtual(paginaAtual);

        final var indicadores = indicadorService.findIndicadorByCodigoPais(codigoPais, paginacao);
        return toResponse(OK, indicadores);
    }
}
