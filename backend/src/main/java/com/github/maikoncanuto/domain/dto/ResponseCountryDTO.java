package com.github.maikoncanuto.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.maikoncanuto.domain.deserialize.ResponseCountryDeserialize;
import com.github.maikoncanuto.domain.dto.country.CountryWorldBankDTO;
import com.github.maikoncanuto.domain.dto.country.PaginationCountryDTO;

import java.util.List;

@JsonDeserialize(using = ResponseCountryDeserialize.class)
public class ResponseCountryDTO implements BaseDTO {

    private PaginationCountryDTO pagination;
    private List<CountryWorldBankDTO> countries;

    public PaginationCountryDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationCountryDTO pagination) {
        this.pagination = pagination;
    }

    public List<CountryWorldBankDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryWorldBankDTO> countries) {
        this.countries = countries;
    }
}
