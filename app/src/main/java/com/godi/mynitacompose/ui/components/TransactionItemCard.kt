package com.godi.mynitacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godi.mynitacompose.data.TransactionEntity
import com.godi.mynitacompose.data.TransactionType
import com.godi.mynitacompose.ui.theme.NitaTheme

@Composable
fun TransactionItemCard(
    transaction: TransactionEntity,
) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    shape = CircleShape,
                    color = when (transaction.transactionType) {
                        TransactionType.SEND -> NitaTheme.colors.burntSienna
                        TransactionType.RECEIVE -> NitaTheme.colors.cobaltBlue
                        TransactionType.FAST_FOOD -> NitaTheme.colors.forestGreen
                        else -> NitaTheme.colors.burntSienna
                    },
                )
        ) {
            Icon(
                imageVector = when (transaction.transactionType) {
                    TransactionType.SEND -> Icons.Default.ArrowUpward
                    TransactionType.RECEIVE -> Icons.Default.ArrowDownward
                    TransactionType.SHOP -> Icons.Default.ShoppingBag
                    TransactionType.FAST_FOOD -> Icons.Default.Fastfood
                },
                contentDescription = "action",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(24.dp)
            )
        }
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Column(
            Modifier.weight(1f)
        ) {
            Text(transaction.fullName, fontSize = 16.sp)
            Text(
                text = when (transaction.transactionType) {
                      TransactionType.SEND -> "Envoi"
                      TransactionType.RECEIVE -> "Reception"
                      TransactionType.SHOP -> "Achat"
                      TransactionType.FAST_FOOD -> "Paiement"
                },
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        }
        Text(
            text = when (transaction.transactionType) {
                TransactionType.RECEIVE -> "+${transaction.formattedAmount}"
                else -> "-${transaction.formattedAmount}"
            },
            color = when (transaction.transactionType) {
                TransactionType.RECEIVE -> NitaTheme.colors.forestGreen
                else -> Color.Red
            },
            fontSize = 14.sp
        )
    }
}

val transactions = listOf(
    TransactionEntity("Souleymane", "Sabiou", TransactionType.SEND, 45000.0),
    TransactionEntity("Ma", "Terrasse", TransactionType.FAST_FOOD, 1000.0),
    TransactionEntity("Amina", "Muhammad", TransactionType.RECEIVE, 15000.0),
    TransactionEntity("Bab", "Salam", TransactionType.SHOP, 150000.0),
    TransactionEntity("Ali", "Farsanthe", TransactionType.RECEIVE, 10000.0)
)