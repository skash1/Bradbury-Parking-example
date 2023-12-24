package com.example.model.account

import com.example.model.account.Account.Companion.ACCOUNT_TABLE_NAME
import com.example.model.account.Account.Companion.ACCOUNT_TYPE_COLUMN
import jakarta.persistence.*
import kotlin.jvm.Transient

@Entity(name = ACCOUNT_TABLE_NAME)
@DiscriminatorColumn(name = ACCOUNT_TYPE_COLUMN, discriminatorType = DiscriminatorType.STRING)
abstract class Account(@Transient val accountType: AccountType) {

    @Id
    @GeneratedValue
    open var id: Long = 0
    @Embedded
    open var balance: Balance = Balance.zero()

    companion object {
        const val ACCOUNT_TABLE_NAME = "account"
        const val ACCOUNT_TYPE_COLUMN = "account_type"
    }

}
