package com.econrich.api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "regions")
class Region {

    @Id
    @Column(name = "region_id", nullable = false)
    var regionId: Int = 0

    @Column(length = 25)
    var regionName: String? = null

}