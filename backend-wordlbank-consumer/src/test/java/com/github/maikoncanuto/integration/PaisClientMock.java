package com.github.maikoncanuto.integration;

import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.domain.dto.PaisDTO;
import com.github.maikoncanuto.domain.dto.ResponseApiDTO;
import com.github.maikoncanuto.domain.dto.ResponsePaisDTO;
import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

import static java.util.Collections.singletonList;

@Mock
@RestClient
@ApplicationScoped
public class PaisClientMock implements IPaisClient {


    @Override
    public ResponseApiDTO getPaises(Integer porPagina, Integer paginaAtual) {
        final var paginacaoDTO = new PaginacaoDTO();
        paginacaoDTO.setPaginaAtual(1);
        paginacaoDTO.setPorPagina(1);
        paginacaoDTO.setQuantidadePaginas(10);
        paginacaoDTO.setTotal(100);

        final var pais = new PaisDTO();
        pais.setCodigoPais("BR");
        pais.setNome("Brasil");
        pais.setCapital("Brasilia");

        final var responsePaisDTO = new ResponsePaisDTO();
        responsePaisDTO.setPaginacao(paginacaoDTO);
        responsePaisDTO.setPaises(singletonList(pais));

        final var responseApiDTO = new ResponseApiDTO();
        responseApiDTO.setCode("200");
        responseApiDTO.setData(responsePaisDTO);
        responseApiDTO.setErro(null);

        return responseApiDTO;
    }
}
