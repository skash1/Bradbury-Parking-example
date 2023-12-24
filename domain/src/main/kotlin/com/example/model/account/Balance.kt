package com.example.model.account

import java.math.BigDecimal
import java.util.Currency

class Balance(val amount: BigDecimal, val currency: Currency) {

    companion object {
        fun zero(): Balance = Balance(BigDecimal.ZERO, Currency.getInstance("USD"))
    }

}
