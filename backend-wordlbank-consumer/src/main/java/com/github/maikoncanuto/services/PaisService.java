package com.github.maikoncanuto.services;

import com.github.maikoncanuto.core.annotations.Audit;
import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.domain.dto.ResponsePaisDTO;
import com.github.maikoncanuto.integration.IPaisClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import static com.github.maikoncanuto.core.config.LabelCache.CACHE_PAISES;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@Audit
@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class PaisService {

    @Inject
    @RestClient
    IPaisClient paisClient;

    @CacheResult(cacheName = CACHE_PAISES)
    public ResponsePaisDTO findAll(final PaginacaoDTO paginacaoParametro) {
        final var response = paisClient.getPaises(paginacaoParametro.getPorPagina(), paginacaoParametro.getPaginaAtual());
        return (ResponsePaisDTO) response.getData();
    }

}
