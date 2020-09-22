package com.ebbers.accountservice.model.mapper

import com.ebbers.accountservice.model.entity.Account
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface AccountMapper {

    @Select("""
        SELECT *
        FROM ACCOUNT a
        WHERE a.id = #{id}
    """)
    fun getAccount(@Param("id") accountId: Int): Account?
}