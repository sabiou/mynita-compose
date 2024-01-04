package com.godi.mynitacompose.utils

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

/**
 * Formats the given amount in West African CFA franc (XOF) currency.
 *
 * @param amount The amount to be formatted, of type Double.
 * @return A string representation of the formatted amount in West African CFA franc (XOF) currency.
 */
fun formatAmountToXOF(amount: Double): String {
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale("fr", "XOF"))
    currencyFormat.maximumFractionDigits = 0
    currencyFormat.currency = Currency.getInstance("XOF")
    return currencyFormat.format(amount)
}

fun formatCurrency(value: String): String {
    return try {
        val numberFormat = NumberFormat.getCurrencyInstance(Locale("fr", "XOF"))
        val amount = value.toDoubleOrNull() ?: 0.0
        numberFormat.maximumFractionDigits = 0
        numberFormat.currency = Currency.getInstance("XOF")
        numberFormat.format(amount)
    } catch (e: Exception) {
        value
    }
}

fun calculateFees(amount: String): Int {
    val numericAmount = amount.toIntOrNull() ?: 0
    val baseFee = 400 // Fee for the first 10,000 F CFA
    val remainingAmount = numericAmount - 10000

    var fees = baseFee

    if (remainingAmount > 0) {
        fees += (remainingAmount / 5000) * 200
        if (remainingAmount % 5000 > 0)
            fees += 200
    }
    return fees
}