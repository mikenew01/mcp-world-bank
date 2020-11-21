package com.github.maikoncanuto.services;

import com.github.maikoncanuto.domain.dto.ResponseCountryDTO;
import com.github.maikoncanuto.integration.IWorldBankCountryClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import static com.github.maikoncanuto.core.config.LabelCache.CACHE_COUNTRIES_WORLD_BANK;
import static com.github.maikoncanuto.core.config.LabelRequest.JSON;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class CountryService {

    @Inject
    @RestClient
    IWorldBankCountryClient worldBankCountryClient;


    @CacheResult(cacheName = CACHE_COUNTRIES_WORLD_BANK)
    public ResponseCountryDTO findCountriesInWorldBank() {
        return worldBankCountryClient.getCountries(JSON);
    }

}
