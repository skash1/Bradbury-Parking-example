package com.example.model.account

abstract class Account(val accountType: AccountType) {

    protected var id: Long = 0
    protected var balance: Balance = Balance.zero()

}
