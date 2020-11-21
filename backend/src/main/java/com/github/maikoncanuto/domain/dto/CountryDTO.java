package com.github.maikoncanuto.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDTO implements BaseDTO {

    private String id;
    private String iso2Code;
    private String name;
    private RegionDTO region;
    private RegionDTO incomeLevel;
    private RegionDTO lendingType;
    private String capitalCity;
    private String longitude;
    private String latitude;

    @JsonProperty("adminregion")
    private RegionDTO adminRegion;

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

    public RegionDTO getRegion() {
        return region;
    }

    public void setRegion(RegionDTO region) {
        this.region = region;
    }

    public RegionDTO getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(RegionDTO adminRegion) {
        this.adminRegion = adminRegion;
    }

    public RegionDTO getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(RegionDTO incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public RegionDTO getLendingType() {
        return lendingType;
    }

    public void setLendingType(RegionDTO lendingType) {
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
