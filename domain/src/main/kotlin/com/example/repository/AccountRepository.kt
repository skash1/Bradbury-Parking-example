package com.example.repository

import com.example.model.account.Account

interface AccountRepository: EntityCrudRepository<Account, Long> {
}
