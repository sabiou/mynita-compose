package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.MobileFriendly
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.navigation.MyNitaBottomBar
import com.godi.mynitacompose.ui.components.ActionRow
import com.godi.mynitacompose.ui.components.TransactionItemCard
import com.godi.mynitacompose.ui.components.transactions
import com.godi.mynitacompose.ui.theme.NitaTheme
import com.godi.mynitacompose.utils.formatAmountToXOF

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            HomeTopBar(accountOwner = "Farouk")
        },
        bottomBar = {
            MyNitaBottomBar(navController = navController)
        },
        content = {
            Box(
                modifier = Modifier.padding(it)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TopCard()
                    Spacer(modifier = Modifier.height(24.dp))
                    ActionRow(navController)
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Autres actions",
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OtherActionsList(navController = navController)
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Transactions recentes",
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            modifier = Modifier.clickable { },
                            text = "Plus",
                            fontWeight = FontWeight.ExtraBold,
                            color = NitaTheme.colors.cobaltBlue,
                            style = TextStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    RecentTransactionsList()
                }
            }
        }
    )
}

@Composable
fun RecentTransactionsList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(transactions) {
                TransactionItemCard(it)
            }
        }
    )
}

@Composable
fun TopCard(
) {
    var isAmountVisible by rememberSaveable { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Solde: ${formatAmountToXOF(700000.0)}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = if (!isAmountVisible) Modifier.blur(20.dp) else Modifier.blur(0.dp),
            color = if (!isAmountVisible) Color.Gray else Color.Black
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = when (isAmountVisible) {
                    true -> ImageVector.vectorResource(R.drawable.eye_off)
                    false -> ImageVector.vectorResource(R.drawable.eye)
                },
                contentDescription = if (isAmountVisible) "Cacher solde" else "Afficher solde",
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier.clickable { isAmountVisible = !isAmountVisible },
                text = if (isAmountVisible) "Cacher solde" else "Afficher solde",
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun OtherActionsList(
    navController: NavController
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            item {
                OtherActionCard(
                    action = "Envoyer a moi meme",
                    icon = Icons.Rounded.ArrowDownward,
                    onClick = {}
                )
            }
            item {
                OtherActionCard(
                    action = "Envoi compte à compte",
                    icon = Icons.Rounded.AccountBalanceWallet,
                    onClick = {}
                )
            }
            item {
                OtherActionCard(
                    action = "Paiement de factures",
                    icon = Icons.Rounded.Wallet,
                    onClick = {}
                )
            }
            item {
                OtherActionCard(
                    action = "Transactions bancaires",
                    icon = Icons.Rounded.AccountBalance,
                    onClick = {}
                )
            }
            item {
                OtherActionCard(
                    action = "Achat de credit telephonique",
                    icon = Icons.Rounded.MobileFriendly,
                    onClick = {
                        navController.navigate("airtime")
                    }
                )
            }
        }
    )
}

@Composable
fun OtherActionCard(
    action: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .background(
                color = NitaTheme.colors.cobaltBlue,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .size(155.dp, 100.dp)
            .padding(start = 8.dp, top = 8.dp, end = 8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Color.White
            )
            Text(
                text = action,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    accountOwner: String
) {
    TopAppBar(
        modifier = Modifier
            .padding(end = 12.dp, top = 32.dp)
            .fillMaxWidth()
            .height(40.dp),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hello, $accountOwner",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.W600,
                )

                Box(
                    modifier = Modifier
                        .clickable { }
                        .size(40.dp)
                        .fillMaxWidth()
                        .background(
                            color = NitaTheme.colors.lightSienna,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.bell),
                        contentDescription = "notifications bell",
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            Color.Transparent
        )
    )
}

@Composable
@Preview
fun HomeScreenPreview() {
    NitaTheme {
        HomeScreen(navController = rememberNavController())
    }
}