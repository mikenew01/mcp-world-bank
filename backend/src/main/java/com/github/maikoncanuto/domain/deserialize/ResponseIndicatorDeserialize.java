package com.github.maikoncanuto.domain.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.ResponseIndicatorWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.IndicatorItemWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.IndicatorWorldBankDTO;
import com.github.maikoncanuto.domain.dto.worldbank.indicator.PaginationIndicatorWorldBankDTO;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

public class ResponseIndicatorDeserialize extends JsonDeserializer<ResponseIndicatorWorldBankDTO> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseIndicatorWorldBankDTO deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        final var treeNode = (JsonNode) jsonParser.getCodec().readTree(jsonParser);

        List json = mapper.readerFor(new TypeReference<List<Object>>() {
        }).readValue(treeNode);

        final var pagination = (LinkedHashMap<String, Object>) json.get(0);

        final var paginationDTO = new PaginationIndicatorWorldBankDTO();
        paginationDTO.setTotal((Integer) pagination.get("total"));
        paginationDTO.setPerPage((Integer) pagination.get("per_page"));
        paginationDTO.setLastupdated((String) pagination.get("lastupdated"));
        paginationDTO.setSourceId((String) pagination.get("sourceid"));
        paginationDTO.setPage((Integer) pagination.get("page"));
        paginationDTO.setPages((Integer) pagination.get("pages"));

        final var indicators = ((List<LinkedHashMap<String, Object>>) json.get(1)).stream().map(item -> {
            final var indicator = new IndicatorWorldBankDTO();

            of(item).forEach(indicatorInterno -> {
                indicator.setCountryIso3Code((String) indicatorInterno.get("countryiso3code"));
                indicator.setDate((String) indicatorInterno.get("date"));
                indicator.setUnit((String) indicatorInterno.get("unit"));
                indicator.setObsStatus((String) indicatorInterno.get("obs_status"));
                indicator.setDecimal((Integer) indicatorInterno.get("decimal"));

                indicator.setIndicator(configIndicator(indicatorInterno, "indicator"));
                indicator.setCountry(configIndicator(indicatorInterno, "country"));
            });

            return indicator;
        }).collect(toList());


        final var response = new ResponseIndicatorWorldBankDTO();
        response.setIndicators(indicators);
        response.setPagination(paginationDTO);

        return response;
    }

    private IndicatorItemWorldBankDTO configIndicator(final LinkedHashMap<String, Object> indicatorInterno, final String label) {
        final var countryIndicator = new IndicatorItemWorldBankDTO();

        of((LinkedHashMap<String, Object>) indicatorInterno.get(label)).forEach(variable -> {
            countryIndicator.setId((String) variable.get("id"));
            countryIndicator.setValue((String) variable.get("value"));
        });

        return countryIndicator;
    }
}
