package com.econrich.api.controller

import com.econrich.api.dto.TourDto
import com.econrich.api.service.TourService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tour")
class TourController(private val tourService: TourService) {

    @GetMapping("/list")
    fun getTourList(@ModelAttribute @Valid request: TourDto.request) : TourDto.Body? {
        return tourService.getLocalTourList(request)
    }

}