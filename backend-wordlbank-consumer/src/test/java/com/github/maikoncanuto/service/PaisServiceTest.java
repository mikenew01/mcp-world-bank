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
        final var response = paisService.findAll(new PaginacaoDTO());

        assertNotNull(response.getPaginacao());
        assertNotNull(response.getPaginacao().getPaginaAtual());
        assertNotNull(response.getPaginacao().getPorPagina());
        assertNotNull(response.getPaginacao().getQuantidadePaginas());
        assertNotNull(response.getPaginacao().getTotal());
        assertNotNull(response.getPaises());
        assertNotNull(response.getPaises().get(0));

        assertEquals(1, response.getPaginacao().getPaginaAtual());
        assertEquals(10, response.getPaginacao().getQuantidadePaginas());
        assertEquals(100, response.getPaginacao().getTotal());
        assertEquals(1, response.getPaginacao().getPorPagina());

        assertEquals("BR", response.getPaises().get(0).getCodigoPais());
        assertEquals("Brasil", response.getPaises().get(0).getNome());
        assertEquals("Brasilia", response.getPaises().get(0).getCapital());
    }

}
