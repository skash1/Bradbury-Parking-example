package com.example.model.account

import com.example.model.transport.Transport
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
@DiscriminatorValue("USER")
open class UserAccount : Account(AccountType.USER) {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = TRANSPORT_MAPPING, targetEntity = Transport::class)
    open var transportUnits: MutableList<Transport> = mutableListOf()

    companion object {
        const val TRANSPORT_MAPPING = "owner"
    }
}
