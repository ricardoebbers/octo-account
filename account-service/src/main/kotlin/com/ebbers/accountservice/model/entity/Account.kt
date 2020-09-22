package com.ebbers.accountservice.model.entity

import java.io.Serializable

data class Account(
        val id: Int,
        val customer_id: Int
): Serializable