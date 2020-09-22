package com.ebbers.accountservice.controller

import com.ebbers.accountservice.model.entity.Account
import com.ebbers.accountservice.model.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
        private val accountService: AccountService
) {
    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: Int): Account {
        return accountService.getAccount(id)
    }

}