package com.example.repository

import com.example.model.parking.ParkPlace
import com.example.model.parking.ParkPlaceSize
import com.example.model.parking.Parking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParkPlaceRepository : JpaRepository<ParkPlace, Long> {

    fun findAllByParkingAndSizeIn(parking: Parking, allowedSizes: List<ParkPlaceSize>): List<ParkPlace>

    fun findAllByParkingId(parkingId: Long): List<ParkPlace>

}
