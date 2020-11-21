package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.worldbank.country.CountryWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.country.PaginationCountryWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.country.ResponseCountryWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.IndicatorItemWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.IndicatorWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.PaginationIndicatorWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.ResponseIndicatorWorldBankDTO;
import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;

@Mock
@RestClient
@ApplicationScoped
public class WorldBankCountryClinetMock implements IWorldBankCountryClient {


    @Override
    public ResponseCountryWorldBankDTO getCountries(String format, String perPage, Integer page) {
        final var responseCountry = new ResponseCountryWorldBankDTO();

        final var pagination = new PaginationCountryWorldBankDTO();

        pagination.setPage(1);
        pagination.setPages(7);
        pagination.setPerPage("50");
        pagination.setTotal(304);

        final var country = new CountryWorldBankDTO();
        country.setCapitalCity("Oranjestad");
        country.setId("ABW");
        country.setName("Aruba");
        country.setLatitude("70");
        country.setLongitude("80");

        responseCountry.setCountries(Collections.singletonList(country));
        responseCountry.setPagination(pagination);

        return responseCountry;
    }

    @Override
    public ResponseIndicatorWorldBankDTO getIndicators(String id, String format, Integer page, Integer perPage) {
        final var responseIndicador = new ResponseIndicatorWorldBankDTO();

        final var pagination = new PaginationIndicatorWorldBankDTO();

        pagination.setPage(1);
        pagination.setPages(2);
        pagination.setPerPage(50);
        pagination.setTotal(62);

        final var indicator = new IndicatorWorldBankDTO();

        final var indicatorItem = new IndicatorItemWorldBankDTO();
        indicatorItem.setId("SI.POV.DDAY");
        indicatorItem.setValue("Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)");

        final var countryItem = new IndicatorItemWorldBankDTO();
        countryItem.setId("AW");
        countryItem.setValue("Aruba");

        indicator.setDate("2020");
        indicator.setCountryIso3Code("ABW");
        indicator.setCountry(countryItem);
        indicator.setIndicator(indicatorItem);

        responseIndicador.setIndicators(Collections.singletonList(indicator));
        responseIndicador.setPagination(pagination);

        return responseIndicador;
    }
}
