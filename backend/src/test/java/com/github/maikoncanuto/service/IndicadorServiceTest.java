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

    private static final String CODIGO_PAIS = "FRA";

    @Inject
    IndicadorService indicadorService;

    @Test
    void testRetornoFindIndicatorsByIdInWorldBank() {
        final var indicadorResponse = indicadorService.findIndicatorsByIdInWorldBank(CODIGO_PAIS, new PaginacaoDTO());

        assertNotNull(indicadorResponse);
        assertNotNull(indicadorResponse.getIndicadores());
        assertNotNull(indicadorResponse.getIndicadores().get(0));
        assertNotNull(indicadorResponse.getPaginacao());
        assertNotNull(indicadorResponse.getPaginacao().getPaginaAtual());
        assertNotNull(indicadorResponse.getPaginacao().getPorPagina());
        assertNotNull(indicadorResponse.getPaginacao().getQuantidadePaginas());
        assertNotNull(indicadorResponse.getPaginacao().getTotal());

        assertEquals(1, indicadorResponse.getPaginacao().getPaginaAtual());
        assertEquals(2, indicadorResponse.getPaginacao().getQuantidadePaginas());
        assertEquals(50, indicadorResponse.getPaginacao().getPorPagina());
        assertEquals(62, indicadorResponse.getPaginacao().getTotal());

        assertEquals(1, indicadorResponse.getIndicadores().size());
        assertEquals(2020, indicadorResponse.getIndicadores().get(0).getDataAno());
        assertEquals("ABW", indicadorResponse.getIndicadores().get(0).getCodigoPais());
        assertEquals("SI.POV.DDAY", indicadorResponse.getIndicadores().get(0).getCodigoIndicador());
        assertEquals("Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)", indicadorResponse.getIndicadores().get(0).getIndicador());
        assertEquals("Aruba", indicadorResponse.getIndicadores().get(0).getNomePais());
    }

}
