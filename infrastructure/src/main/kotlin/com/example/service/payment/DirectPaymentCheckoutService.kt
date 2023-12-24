package com.example.service.payment

import com.example.model.Cost
import com.example.model.account.Account
import com.example.repository.AccountRepository
import com.example.service.PaymentCheckoutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class DirectPaymentCheckoutService @Autowired constructor(
    private val accountRepository: AccountRepository
) : PaymentCheckoutService {
    //may use some payment strategies, like call to payment provider, etc.
    override fun pay(fromAccount: Account, toAccount: Account, cost: Cost) {
        applyBalanceAmount(fromAccount, fromAccount.balance.amount.subtract(cost.amount))
        applyBalanceAmount(toAccount, toAccount.balance.amount.add(cost.amount))
    }

    private fun applyBalanceAmount(fromAccount: Account, amount: BigDecimal) {
        fromAccount.apply {
            fromAccount.balance.amount = amount
        }.also {
            accountRepository.save(fromAccount)
        }
    }

}
