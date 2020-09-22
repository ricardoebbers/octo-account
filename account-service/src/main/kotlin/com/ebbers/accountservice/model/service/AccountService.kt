package com.ebbers.accountservice.model.service

import com.ebbers.accountservice.model.entity.Account

interface AccountService {

    fun getAccount(accountId: Int): Account

}
