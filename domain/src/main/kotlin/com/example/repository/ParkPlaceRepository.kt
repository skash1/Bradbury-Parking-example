package com.example.repository

import com.example.model.parking.ParkPlace
import com.example.model.parking.ParkPlaceSize
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParkPlaceRepository : JpaRepository<ParkPlace, Long> {

    fun findAllBySizeIn(allowedSizes: List<ParkPlaceSize>): List<ParkPlace>

}
