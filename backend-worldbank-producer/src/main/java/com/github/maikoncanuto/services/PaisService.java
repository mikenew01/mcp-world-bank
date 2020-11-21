package com.github.maikoncanuto.services;

import com.github.maikoncanuto.core.annotations.Audit;
import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.domain.dto.PaisDTO;
import com.github.maikoncanuto.domain.dto.ResponsePaisDTO;
import com.github.maikoncanuto.integration.IWorldBankCountryClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Objects;

import static com.github.maikoncanuto.core.config.LabelCache.CACHE_COUNTRIES_WORLD_BANK;
import static com.github.maikoncanuto.core.config.LabelRequest.JSON;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@Audit
@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class PaisService {

    @Inject
    @RestClient
    IWorldBankCountryClient worldBankCountryClient;


    @CacheResult(cacheName = CACHE_COUNTRIES_WORLD_BANK)
    public ResponsePaisDTO findCountriesInWorldBank(final PaginacaoDTO paginacaoParametro) {
        final var countries = worldBankCountryClient.getCountries(JSON,
                paginacaoParametro.getPorPagina().toString(),
                paginacaoParametro.getPaginaAtual());

        final var paginacao = new PaginacaoDTO();
        paginacao.setTotal(countries.getPagination().getTotal());
        paginacao.setQuantidadePaginas(countries.getPagination().getPages());
        paginacao.setPorPagina(parseInt(countries.getPagination().getPerPage()));
        paginacao.setPaginaAtual(countries.getPagination().getPage());


        final var paises = countries.getCountries().stream().filter(Objects::nonNull).map(countryWorldBankDTO -> {
            final var pais = new PaisDTO();

            pais.setCapital(countryWorldBankDTO.getCapitalCity());
            pais.setCodigoPais(countryWorldBankDTO.getId());
            pais.setNome(countryWorldBankDTO.getName());

            return pais;
        }).collect(toList());


        final var responsePais = new ResponsePaisDTO();

        responsePais.setPaginacao(paginacao);
        responsePais.setPaises(paises);

        return responsePais;
    }

}
