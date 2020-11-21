package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.IndicadorDTO;
import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.domain.dto.ResponseApiDTO;
import com.github.maikoncanuto.domain.dto.ResponseIndicadorDTO;
import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

import static java.util.Collections.singletonList;


@Mock
@RestClient
@ApplicationScoped
public class IndicadorClientMock implements IIndicadorClient {


    @Override
    public ResponseApiDTO getIndicadores(String codigoPais, Integer porPagina, Integer paginaAtual) {
        final var paginacaoDTO = new PaginacaoDTO();
        paginacaoDTO.setPaginaAtual(1);
        paginacaoDTO.setPorPagina(1);
        paginacaoDTO.setQuantidadePaginas(10);
        paginacaoDTO.setTotal(100);

        final var indicadorDTO = new IndicadorDTO();

        indicadorDTO.setDataAno(2020);
        indicadorDTO.setCodigoIndicador("SI.POV.DDAY");
        indicadorDTO.setIndicador("Mensagem para validacao");
        indicadorDTO.setNomePais("Brasil");
        indicadorDTO.setCodigoPais("BR");

        final var response = new ResponseIndicadorDTO();
        response.setPaginacao(paginacaoDTO);
        response.setIndicadores(singletonList(indicadorDTO));

        final var responseApiDTO = new ResponseApiDTO();
        responseApiDTO.setCode("200");
        responseApiDTO.setData(response);
        responseApiDTO.setErro(null);

        return responseApiDTO;
    }
}
