package com.godi.mynitacompose.data

import com.godi.mynitacompose.utils.formatAmountToXOF

data class TransactionEntity(
    val firstName: String,
    val lastName: String,
    val transactionType: TransactionType,
    val amount: Double,
) {
    val fullName = "$firstName $lastName"
    val formattedAmount = formatAmountToXOF(amount)
}

enum class TransactionType {
    SEND,
    RECEIVE,
    SHOP,
    FAST_FOOD
}
