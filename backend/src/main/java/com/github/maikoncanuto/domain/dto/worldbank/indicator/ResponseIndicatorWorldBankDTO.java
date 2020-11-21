package com.github.maikoncanuto.domain.dto.worldbank.indicator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.maikoncanuto.domain.deserialize.ResponseIndicatorDeserialize;
import com.github.maikoncanuto.domain.dto.BaseDTO;

import java.util.List;

@JsonDeserialize(using = ResponseIndicatorDeserialize.class)
public class ResponseIndicatorWorldBankDTO implements BaseDTO {

    private PaginationIndicatorWorldBankDTO pagination;
    private List<IndicatorWorldBankDTO> indicators;

    public PaginationIndicatorWorldBankDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationIndicatorWorldBankDTO pagination) {
        this.pagination = pagination;
    }

    public List<IndicatorWorldBankDTO> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<IndicatorWorldBankDTO> indicators) {
        this.indicators = indicators;
    }
}
