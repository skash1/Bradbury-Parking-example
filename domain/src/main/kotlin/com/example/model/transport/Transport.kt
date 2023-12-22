package com.example.model.transport

abstract class Transport(
    val transportType: TransportType
) {
    protected var id: Long = 0
}
