package com.github.maikoncanuto.services;

import com.github.maikoncanuto.core.annotations.Audit;
import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.domain.dto.ResponseIndicadorDTO;
import com.github.maikoncanuto.integration.IIndicadorClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import static com.github.maikoncanuto.core.config.LabelCache.CACHE_INDICADORES;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@Audit
@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class IndicadorService {

    @Inject
    @RestClient
    IIndicadorClient indicadorClient;

    @CacheResult(cacheName = CACHE_INDICADORES)
    public ResponseIndicadorDTO findIndicadorByCodigoPais(final String codigoPais, final PaginacaoDTO paginacaoParametro) {
        final var indicadores = indicadorClient.getIndicadores(codigoPais, paginacaoParametro.getPorPagina(), paginacaoParametro.getPaginaAtual());
        return (ResponseIndicadorDTO) indicadores.getData();
    }

}
