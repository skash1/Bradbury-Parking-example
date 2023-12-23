package com.example.service.payment

import com.example.model.account.Account
import com.example.model.cost.Cost
import com.example.repository.AccountRepository
import com.example.service.PaymentCheckoutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DirectPaymentCheckoutService @Autowired constructor(
    private val accountRepository: AccountRepository
) : PaymentCheckoutService {
    override fun pay(account: Account, cost: Cost) {
        account.apply {
            account.balance.amount = account.balance.amount.subtract(cost.amount)
        }.also {
            accountRepository.save(account)
        }
    }

}
