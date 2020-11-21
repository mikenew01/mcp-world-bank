package com.github.maikoncanuto.domain.dto.worldbank.country;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.maikoncanuto.domain.deserialize.ResponseCountryDeserialize;
import com.github.maikoncanuto.domain.dto.BaseDTO;

import java.util.List;

@JsonDeserialize(using = ResponseCountryDeserialize.class)
public class ResponseCountryWorldBankDTO implements BaseDTO {

    private PaginationCountryWorldBankDTO pagination;
    private List<CountryWorldBankDTO> countries;

    public PaginationCountryWorldBankDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationCountryWorldBankDTO pagination) {
        this.pagination = pagination;
    }

    public List<CountryWorldBankDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryWorldBankDTO> countries) {
        this.countries = countries;
    }
}
