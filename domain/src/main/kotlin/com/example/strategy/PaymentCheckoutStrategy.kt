package com.example.strategy

import com.example.model.Cost
import com.example.model.account.Account

fun interface PaymentCheckoutStrategy {

    fun pay(account: Account, cost: Cost)

}
