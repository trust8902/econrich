package com.econrich.api.domain

import jakarta.persistence.*

@Entity(name = "countries")
class Country {

    @Id
    @Column(name = "country_id", length = 2, nullable = false)
    var countryId: String? = null

    @Column(length = 40)
    var countryName: String? = null

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    var region: Region? = null
}