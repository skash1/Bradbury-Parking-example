package com.example.model.transport

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("CAR")
class Car : Transport(TransportType.CAR) {
}
