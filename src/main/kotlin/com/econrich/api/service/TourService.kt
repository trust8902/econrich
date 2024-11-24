package com.econrich.api.service

import com.econrich.api.dto.TourDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory

@Service
class TourService(
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper
) {

    fun getLocalTourList(request: TourDto.request) : TourDto.Body? {
        val baseUrl = "https://apis.data.go.kr/B551011/TarRlteTarService/areaBasedList"
        val factory = DefaultUriBuilderFactory(baseUrl)
            factory.encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE
        restTemplate.uriTemplateHandler = factory

        val entity = HttpEntity<String>(HttpHeaders().apply {
            accept = listOf(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
        })

        val url = factory.uriString("")
            .queryParam("serviceKey", "JPICLsUHbu9hsGEwcxsUxCF5dQZQBwgxbzCdbto0h6DcFIh1ikXlc9wyoFg7t19%2FRTkJdsE7Q%2BNu8jEBIIIQWA%3D%3D")
            .queryParam("pageNo", request.pageNo)
            .queryParam("numOfRows", request.numOfRows)
            .queryParam("MobileOS", "WEB")
            .queryParam("MobileApp", "test")
            .queryParam("baseYm", request.baseYm)
            .queryParam("areaCd", request.areaCd)
            .queryParam("signguCd", request.signguCd)
            .queryParam("_type", "json")
            .build().toString()

        val response = restTemplate.exchange(url, HttpMethod.GET, entity, Map::class.java)
        val bodyMap = (response.body as? Map<*, *>)?.get("response") as? Map<*, *>
        val bodyJson = objectMapper.writeValueAsString(bodyMap?.get("body"))

        return objectMapper.readValue(bodyJson, TourDto.Body::class.java)
    }
}