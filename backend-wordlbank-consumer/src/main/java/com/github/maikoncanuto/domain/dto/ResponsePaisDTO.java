package com.github.maikoncanuto.domain.dto;

import java.util.List;

public class ResponsePaisDTO implements BaseDTO {

    private PaginacaoDTO paginacao;
    private List<PaisDTO> paises;

    public PaginacaoDTO getPaginacao() {
        return paginacao;
    }

    public void setPaginacao(PaginacaoDTO paginacao) {
        this.paginacao = paginacao;
    }

    public List<PaisDTO> getPaises() {
        return paises;
    }

    public void setPaises(List<PaisDTO> paises) {
        this.paises = paises;
    }
}
