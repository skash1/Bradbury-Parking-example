package com.example.model.account

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
class Balance(
    @Column
    var amount: BigDecimal
) {

    companion object {
        fun zero(): Balance = Balance(BigDecimal.ZERO)
    }

}
