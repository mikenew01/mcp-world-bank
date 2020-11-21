package com.github.maikoncanuto.domain.dto.worldbank.indicator;

import com.github.maikoncanuto.domain.dto.BaseDTO;

public class IndicatorWorldBankDTO implements BaseDTO {

    private IndicatorItemWorldBankDTO indicator;
    private IndicatorItemWorldBankDTO country;
    private String countryIso3Code;
    private String date;
    private Object value;
    private String unit;
    private String obsStatus;
    private Integer decimal;

    public IndicatorItemWorldBankDTO getIndicator() {
        return indicator;
    }

    public void setIndicator(IndicatorItemWorldBankDTO indicator) {
        this.indicator = indicator;
    }

    public IndicatorItemWorldBankDTO getCountry() {
        return country;
    }

    public void setCountry(IndicatorItemWorldBankDTO country) {
        this.country = country;
    }

    public String getCountryIso3Code() {
        return countryIso3Code;
    }

    public void setCountryIso3Code(String countryIso3Code) {
        this.countryIso3Code = countryIso3Code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getObsStatus() {
        return obsStatus;
    }

    public void setObsStatus(String obsStatus) {
        this.obsStatus = obsStatus;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }
}
