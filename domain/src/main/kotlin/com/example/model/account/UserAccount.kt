package com.example.model.account

import com.example.model.transport.Transport

class UserAccount : Account(AccountType.USER) {
    private var transportUnits: List<Transport> = listOf()
}
