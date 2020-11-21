package com.github.maikoncanuto.service;


import com.github.maikoncanuto.domain.dto.PaginacaoDTO;
import com.github.maikoncanuto.services.IndicadorService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class IndicadorServiceTest {

    private static final String CODIGO_PAIS = "BR";

    @Inject
    IndicadorService indicadorService;

    @Test
    void testRetornoFindIndicadorByCodigoPais() {
        final var indicadorResponse = indicadorService.findIndicadorByCodigoPais(CODIGO_PAIS, new PaginacaoDTO());

        assertNotNull(indicadorResponse);
        assertNotNull(indicadorResponse.getIndicadores());
        assertNotNull(indicadorResponse.getIndicadores().get(0));
        assertNotNull(indicadorResponse.getPaginacao());
        assertNotNull(indicadorResponse.getPaginacao().getPaginaAtual());
        assertNotNull(indicadorResponse.getPaginacao().getPorPagina());
        assertNotNull(indicadorResponse.getPaginacao().getQuantidadePaginas());
        assertNotNull(indicadorResponse.getPaginacao().getTotal());

        assertEquals(1, indicadorResponse.getPaginacao().getPaginaAtual());
        assertEquals(10, indicadorResponse.getPaginacao().getQuantidadePaginas());
        assertEquals(1, indicadorResponse.getPaginacao().getPorPagina());
        assertEquals(100, indicadorResponse.getPaginacao().getTotal());

        assertEquals(1, indicadorResponse.getIndicadores().size());
        assertEquals(2020, indicadorResponse.getIndicadores().get(0).getDataAno());
        assertEquals("BR", indicadorResponse.getIndicadores().get(0).getCodigoPais());
        assertEquals("SI.POV.DDAY", indicadorResponse.getIndicadores().get(0).getCodigoIndicador());
        assertEquals("Mensagem para validacao", indicadorResponse.getIndicadores().get(0).getIndicador());
        assertEquals("Brasil", indicadorResponse.getIndicadores().get(0).getNomePais());
    }

}
