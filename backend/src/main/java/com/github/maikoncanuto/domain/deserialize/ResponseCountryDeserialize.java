package com.github.maikoncanuto.domain.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.maikoncanuto.domain.dto.country.CountryWorldBankDTO;
import com.github.maikoncanuto.domain.dto.country.PaginationCountryDTO;
import com.github.maikoncanuto.domain.dto.ResponseCountryDTO;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

public class ResponseCountryDeserialize extends JsonDeserializer<ResponseCountryDTO> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseCountryDTO deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        final var objectCodec = jsonParser.getCodec();
        final var treeNode = (JsonNode) objectCodec.readTree(jsonParser);


        List json = mapper.readerFor(new TypeReference<List<Object>>() {}).readValue(treeNode);

        final var pagination = (LinkedHashMap<String, Object>) json.get(0);

        final var paginationDTO = new PaginationCountryDTO();
        paginationDTO.setTotal((Integer) pagination.get("total"));
        paginationDTO.setPerPage((String) pagination.get("per_page"));
        paginationDTO.setPages((Integer) pagination.get("pages"));
        paginationDTO.setPage((Integer) pagination.get("page"));

        final var estados = (List<LinkedHashMap<String, Object>>) json.get(1);

        final var countries = estados.stream().map(item -> {
            final var country = new CountryWorldBankDTO();

            of(item).forEach(countryInterno -> {
                country.setName((String) countryInterno.get("name"));
                country.setIso2Code((String) countryInterno.get("iso2Code"));
                country.setId((String) countryInterno.get("id"));
                country.setCapitalCity((String) countryInterno.get("capitalCity"));
                country.setLatitude((String) countryInterno.get("latitude"));
                country.setLongitude((String) countryInterno.get("longitude"));
            });

            return country;
        }).collect(toList());


        final var response = new ResponseCountryDTO();
        response.setCountries(countries);
        response.setPagination(paginationDTO);

        return response;
    }
}
