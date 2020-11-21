package com.github.maikoncanuto.domain.dto;

import com.github.maikoncanuto.domain.dto.BaseDTO;

public class ResponseApiDTO implements BaseDTO {

    private String code;
    private Object data;
    private String erro;

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
