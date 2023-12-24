package com.example.model.transport

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("TRUCK")
class Truck : Transport(TransportType.TRUCK) {
}
