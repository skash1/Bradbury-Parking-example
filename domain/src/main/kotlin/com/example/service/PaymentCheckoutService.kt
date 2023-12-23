package com.example.service

import com.example.model.account.Account
import com.example.model.cost.Cost

fun interface PaymentCheckoutService {

    fun pay(account: Account, cost: Cost)

}
