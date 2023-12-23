package com.example.model.parking

import com.example.model.parking.ParkPlace.Companion.PARK_PLACE_TABLE_NAME
import com.example.model.transport.Transport
import jakarta.persistence.*
import java.time.Instant

@Entity(name = PARK_PLACE_TABLE_NAME)
open class ParkPlace {

    @Id
    @GeneratedValue
    open var id: Long = 0

    @Enumerated(EnumType.STRING)
    @Column
    open var size: ParkPlaceSize = ParkPlaceSize.S

    @Column(name = CAPACITY_USED_COLUMN_NAME)
    open var capacityUsed: Int = size.capacity

    @Column(name = TAKE_MOMENT_COLUMN_NAME)
    open var takeMoment: Instant? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = PARK_PLACE_MAPPING, targetEntity = Transport::class)
    open var transportUnits: MutableList<Transport> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = PARKING_MAPPING_COLUMN_NAME, nullable = false)
    open var parking: Parking? = null

    companion object {
        const val PARK_PLACE_TABLE_NAME = "park_place"
        const val PARK_PLACE_MAPPING = "takenParkPlace"
        const val CAPACITY_USED_COLUMN_NAME = "capacity_used"
        const val TAKE_MOMENT_COLUMN_NAME = "take_moment"
        const val PARKING_MAPPING_COLUMN_NAME = "parking_id"
    }
}
