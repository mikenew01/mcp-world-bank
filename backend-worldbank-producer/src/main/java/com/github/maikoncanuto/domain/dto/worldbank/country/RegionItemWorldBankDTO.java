package com.github.maikoncanuto.domain.dto.worldbank.country;

import com.github.maikoncanuto.domain.dto.BaseDTO;

public class RegionItemWorldBankDTO implements BaseDTO {

    private String id;
    private String iso2code;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso2code() {
        return iso2code;
    }

    public void setIso2code(String iso2code) {
        this.iso2code = iso2code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
