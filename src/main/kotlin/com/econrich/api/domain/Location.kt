package com.econrich.api.domain

import jakarta.persistence.*

@Entity(name = "locations")
class Location {

    @Id
    @Column(name = "location_id", nullable = false)
    var locationId: Int = 0

    @Column(length = 40)
    var streetAddress: String? = null

    @Column(length = 12)
    var postalCode: String? = null

    @Column(length = 30, nullable = false)
    var city: String? = null

    @Column(length = 25)
    var stateProvince: String? = null

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    var country: Country? = null
}