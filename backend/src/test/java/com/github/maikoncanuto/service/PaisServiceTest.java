package com.github.maikoncanuto.service;

import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.services.PaisService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class PaisServiceTest {


    @Inject
    PaisService paisService;

    @Test
    void testRetornoFindCountriesInWorldBank() {
        final var countriesResponse = paisService.findCountriesInWorldBank(new PaginacaoDTO());

        assertNotNull(countriesResponse.getPaginacao());
        assertNotNull(countriesResponse.getPaginacao().getPaginaAtual());
        assertNotNull(countriesResponse.getPaginacao().getPorPagina());
        assertNotNull(countriesResponse.getPaginacao().getQuantidadePaginas());
        assertNotNull(countriesResponse.getPaginacao().getTotal());
        assertNotNull(countriesResponse.getPaises());
        assertNotNull(countriesResponse.getPaises().get(0));

        assertEquals(1, countriesResponse.getPaginacao().getPaginaAtual());
        assertEquals(7, countriesResponse.getPaginacao().getQuantidadePaginas());
        assertEquals(304, countriesResponse.getPaginacao().getTotal());
        assertEquals(50, countriesResponse.getPaginacao().getPorPagina());

        assertEquals("ABW", countriesResponse.getPaises().get(0).getCodigoPais());
        assertEquals("Aruba", countriesResponse.getPaises().get(0).getNome());
        assertEquals("Oranjestad", countriesResponse.getPaises().get(0).getCapital());
    }

}
