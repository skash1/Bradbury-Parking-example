package com.example.model.transport

import com.example.model.account.Account
import com.example.model.parking.ParkPlace
import com.example.model.transport.Transport.Companion.TRANSPORT_TABLE_NAME
import com.example.model.transport.Transport.Companion.TRANSPORT_TYPE_COLUMN_NAME
import jakarta.persistence.*

@Entity(name = TRANSPORT_TABLE_NAME)
@DiscriminatorColumn(name = TRANSPORT_TYPE_COLUMN_NAME, discriminatorType = DiscriminatorType.STRING)
abstract class Transport(@Transient val transportType: TransportType) {
    @Id
    @GeneratedValue
    open var id: Long = 0

    @ManyToOne
    @JoinColumn(name = USER_ACCOUNT_MAPPING_COLUMN_NAME, nullable = false)
    open var owner: Account? = null

    @ManyToOne
    @JoinColumn(name = PARK_PLACE_MAPPING_COLUMN_NAME, nullable = true)
    open var takenParkPlace: ParkPlace? = null

    companion object {
        const val TRANSPORT_TABLE_NAME = "transport"
        const val TRANSPORT_TYPE_COLUMN_NAME = "transport_type"
        const val USER_ACCOUNT_MAPPING_COLUMN_NAME = "owner_id"
        const val PARK_PLACE_MAPPING_COLUMN_NAME = "park_place_id"
    }
}
