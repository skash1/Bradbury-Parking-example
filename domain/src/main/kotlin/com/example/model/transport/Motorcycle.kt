package com.example.model.transport

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("MOTORCYCLE")
class Motorcycle : Transport(TransportType.MOTORCYCLE) {
}
