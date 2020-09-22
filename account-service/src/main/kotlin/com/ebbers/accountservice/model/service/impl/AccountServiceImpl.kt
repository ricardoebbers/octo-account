package com.ebbers.accountservice.model.service.impl

import com.ebbers.accountservice.model.entity.Account
import com.ebbers.accountservice.model.exception.NotFoundException
import com.ebbers.accountservice.model.mapper.AccountMapper
import com.ebbers.accountservice.model.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
        private val mapper: AccountMapper
) : AccountService {
    override fun getAccount(accountId: Int): Account {
        return mapper.getAccount(accountId) ?: throw NotFoundException()
    }
}