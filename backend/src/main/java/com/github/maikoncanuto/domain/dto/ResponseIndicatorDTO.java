package com.github.maikoncanuto.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.maikoncanuto.domain.deserialize.ResponseIndicatorDeserialize;
import com.github.maikoncanuto.domain.dto.indicator.IndicatorWorldBankDTO;
import com.github.maikoncanuto.domain.dto.indicator.PaginationIndicatorDTO;

import java.util.List;

@JsonDeserialize(using = ResponseIndicatorDeserialize.class)
public class ResponseIndicatorDTO implements BaseDTO {

    private PaginationIndicatorDTO pagination;
    private List<IndicatorWorldBankDTO> indicators;

    public PaginationIndicatorDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationIndicatorDTO pagination) {
        this.pagination = pagination;
    }

    public List<IndicatorWorldBankDTO> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<IndicatorWorldBankDTO> indicators) {
        this.indicators = indicators;
    }
}
