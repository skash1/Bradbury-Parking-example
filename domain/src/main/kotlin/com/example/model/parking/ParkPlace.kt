package com.example.model.parking

class ParkPlace {

    private var id: Long = 0
    private var size: ParkPlaceSize = ParkPlaceSize.S
    private var capacityUsed: Int = size.capacity

}
