package com.github.maikoncanuto.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.maikoncanuto.domain.deserialize.ResponseCountryDeserialize;

import java.util.List;

@JsonDeserialize(using = ResponseCountryDeserialize.class)
public class ResponseCountryDTO implements BaseDTO {

    private PaginationDTO pagination;
    private List<CountryDTO> countries;

    public PaginationDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDTO pagination) {
        this.pagination = pagination;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }
}
