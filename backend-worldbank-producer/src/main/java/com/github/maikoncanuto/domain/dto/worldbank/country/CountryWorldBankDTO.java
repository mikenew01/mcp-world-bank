package com.github.maikoncanuto.domain.dto.worldbank.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.maikoncanuto.domain.dto.BaseDTO;

public class CountryWorldBankDTO implements BaseDTO {

    private String id;
    private String iso2Code;
    private String name;
    private RegionItemWorldBankDTO region;
    private RegionItemWorldBankDTO incomeLevel;
    private RegionItemWorldBankDTO lendingType;
    private String capitalCity;
    private String longitude;
    private String latitude;

    @JsonProperty("adminregion")
    private RegionItemWorldBankDTO adminRegion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso2Code() {
        return iso2Code;
    }

    public void setIso2Code(String iso2Code) {
        this.iso2Code = iso2Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionItemWorldBankDTO getRegion() {
        return region;
    }

    public void setRegion(RegionItemWorldBankDTO region) {
        this.region = region;
    }

    public RegionItemWorldBankDTO getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(RegionItemWorldBankDTO adminRegion) {
        this.adminRegion = adminRegion;
    }

    public RegionItemWorldBankDTO getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(RegionItemWorldBankDTO incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public RegionItemWorldBankDTO getLendingType() {
        return lendingType;
    }

    public void setLendingType(RegionItemWorldBankDTO lendingType) {
        this.lendingType = lendingType;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
