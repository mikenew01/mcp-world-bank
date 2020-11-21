package com.github.maikoncanuto.domain.dto;

public class IndicadorDTO implements BaseDTO {

    private Integer dataAno;
    private String codigoPais;
    private String nomePais;
    private String indicador;
    private String codigoIndicador;

    public Integer getDataAno() {
        return dataAno;
    }

    public void setDataAno(Integer dataAno) {
        this.dataAno = dataAno;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getCodigoIndicador() {
        return codigoIndicador;
    }

    public void setCodigoIndicador(String codigoIndicador) {
        this.codigoIndicador = codigoIndicador;
    }
}
