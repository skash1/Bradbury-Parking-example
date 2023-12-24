package com.example.repository

import com.example.model.parking.Parking

interface ParkingRepository : EntityCrudRepository<Parking, Long> {
}
