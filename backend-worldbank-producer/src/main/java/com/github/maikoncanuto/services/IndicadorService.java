package com.github.maikoncanuto.services;

import com.github.maikoncanuto.core.annotations.Audit;
import com.github.maikoncanuto.domain.dto.IndicadorDTO;
import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.domain.dto.ResponseIndicadorDTO;
import com.github.maikoncanuto.integration.IWorldBankCountryClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Objects;

import static com.github.maikoncanuto.core.config.LabelCache.CACHE_INDICATORS_WORLD_BANK;
import static com.github.maikoncanuto.core.config.LabelRequest.JSON;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@Audit
@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class IndicadorService {

    @Inject
    @RestClient
    IWorldBankCountryClient worldBankCountryClient;

    @CacheResult(cacheName = CACHE_INDICATORS_WORLD_BANK)
    public ResponseIndicadorDTO findIndicatorsByIdInWorldBank(final String codigoPais, final PaginacaoDTO paginacaoParametro) {
        final var indicators = worldBankCountryClient.getIndicators(codigoPais,
                JSON,
                paginacaoParametro.getPaginaAtual(),
                paginacaoParametro.getPorPagina());

        final var paginacao = new PaginacaoDTO();
        paginacao.setPaginaAtual(indicators.getPagination().getPage());
        paginacao.setPorPagina(indicators.getPagination().getPerPage());
        paginacao.setQuantidadePaginas(indicators.getPagination().getPages());
        paginacao.setTotal(indicators.getPagination().getTotal());

        final var indicadores = indicators.getIndicators().stream().filter(Objects::nonNull).map(indicatorWorldBankDTO -> {
            final var indicador = new IndicadorDTO();
            indicador.setCodigoPais(indicatorWorldBankDTO.getCountryIso3Code());
            indicador.setDataAno(Integer.parseInt(indicatorWorldBankDTO.getDate()));
            indicador.setNomePais(indicatorWorldBankDTO.getCountry().getValue());
            indicador.setIndicador(indicatorWorldBankDTO.getIndicator().getValue());
            indicador.setCodigoIndicador(indicatorWorldBankDTO.getIndicator().getId());

            return indicador;
        }).sorted(comparing(IndicadorDTO::getDataAno)).collect(toList());

        final var responseIndicador = new ResponseIndicadorDTO();
        responseIndicador.setPaginacao(paginacao);
        responseIndicador.setIndicadores(indicadores);

        return responseIndicador;
    }

}
