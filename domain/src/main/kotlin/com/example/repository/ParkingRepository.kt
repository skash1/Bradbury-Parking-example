package com.example.repository

import com.example.model.parking.Parking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParkingRepository : JpaRepository<Parking, Long> {
}
