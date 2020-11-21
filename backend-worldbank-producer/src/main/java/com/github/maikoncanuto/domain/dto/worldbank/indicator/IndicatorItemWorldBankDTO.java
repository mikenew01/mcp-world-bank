package com.github.maikoncanuto.domain.dto.worldbank.indicator;

import com.github.maikoncanuto.domain.dto.BaseDTO;

public class IndicatorItemWorldBankDTO implements BaseDTO {

    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
