package com.example.service

import com.example.model.Cost
import com.example.model.account.Account

fun interface PaymentCheckoutService {

    fun pay(fromAccount: Account, toAccount: Account, cost: Cost)

}
