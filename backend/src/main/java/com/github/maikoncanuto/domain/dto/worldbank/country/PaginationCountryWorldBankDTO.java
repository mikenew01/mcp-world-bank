package com.github.maikoncanuto.domain.dto.worldbank.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.maikoncanuto.domain.dto.BaseDTO;

public class PaginationCountryWorldBankDTO implements BaseDTO {

    private Integer page;

    private Integer pages;

    @JsonProperty(value = "per_page")
    private String perPage;

    private Integer total;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
