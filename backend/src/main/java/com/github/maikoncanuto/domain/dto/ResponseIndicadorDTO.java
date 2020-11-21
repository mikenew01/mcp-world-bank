package com.github.maikoncanuto.domain.dto;

import java.util.List;

public class ResponseIndicadorDTO implements BaseDTO {

    private PaginacaoDTO paginacao;

    private List<IndicadorDTO> indicadores;

    public PaginacaoDTO getPaginacao() {
        return paginacao;
    }

    public void setPaginacao(PaginacaoDTO paginacao) {
        this.paginacao = paginacao;
    }

    public List<IndicadorDTO> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<IndicadorDTO> indicadores) {
        this.indicadores = indicadores;
    }
}
