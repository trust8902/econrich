package com.econrich.api.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


class TourDto {
    data class request(
        @field:NotNull(message = "Page number does not allow blank values.")
        @field:Min(value = 1, message = "Please enter page number 1 or greater.")
        val pageNo: Int = 1,

        @field:NotNull(message = "Blank values are not allowed for impressions per page.")
        @field:Min(value = 1, message = "Please enter at least 1 impression per page.")
        val numOfRows: Int? = 100,

        @field:NotBlank(message = "Year and month do not allow empty values.")
        val baseYm: String?,

        @field:NotNull(message = "City/province codes do not allow blank values.")
        val areaCd: Int?,

        @field:NotNull(message = "City, county, and district codes do not allow blank values.")
        val signguCd: Int?,
    )

    data class Body(
        val items: Items,
        val numOfRows: Int,
        val pageNo: Int,
        val totalCount: Int,
    )

    data class Items(
        val item: List<Item>
    )

    data class Item(
        val baseYm: String,
        val tAtsNm: String,
        val areaCd: String,
        val areaNm: String,
        val signguCd: String,
        val signguNm: String,
        val rlteTatsNm: String,
        val rlteRegnCd: String,
        val rlteRegnNm: String,
        val rlteSignguCd: String,
        val rlteSignguNm: String,
        val rlteBsicAdres: String,
        val rlteCtgryLclsNm: String,
        val rlteCtgryMclsNm: String,
        val rlteCtgrySclsNm: String,
        val rlteRank: String,
    )
}
