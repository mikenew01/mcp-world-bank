package com.github.maikoncanuto.domain.dto;

public class PaginacaoDTO implements BaseDTO {

    private Integer paginaAtual = 0;
    private Integer quantidadePaginas = 0;
    private Integer total = 0;
    private Integer porPagina = 0;

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
