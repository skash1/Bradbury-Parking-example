package com.example.model.parking

enum class ParkPlaceSize(val capacity: Int) {
    S(1), M(2), L(4);

    companion object {
        fun allWithSuitableCapacity(capacity: Int): List<ParkPlaceSize> =
            ParkPlaceSize.values().filter { it.capacity >= capacity }
    }
}
