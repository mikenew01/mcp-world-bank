package com.github.maikoncanuto.domain.dto;

import com.github.maikoncanuto.domain.dto.BaseDTO;

public class PaginacaoDTO implements BaseDTO {

    private Integer paginaAtual;
    private Integer quantidadePaginas;
    private Integer total;
    private Integer porPagina;

    public Integer getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(Integer paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPorPagina() {
        return porPagina;
    }

    public void setPorPagina(Integer porPagina) {
        this.porPagina = porPagina;
    }
}
