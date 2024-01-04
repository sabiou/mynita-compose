package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme

@Composable
fun AirtimeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val airtel = MobileWalletOption(
        "Airtel",
        R.drawable.airtel_logo
    )
    val zamani = MobileWalletOption(
        "Zamani",
        R.drawable.logo_zamani
    )

    Scaffold(
        topBar = {
        },
        content = { padding ->
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .padding(padding)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Column(
                    modifier = modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Text(
                        text = "Selectionnez un operateur",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 36.sp,
                    )
                    BillsOptionsCard(
                        option = airtel,
                    ) {
                        navController.navigate("topUp")
                    }
                    Divider(Modifier.height(0.5.dp))
                    BillsOptionsCard(
                        option = zamani,
                    ) {
                        navController.navigate("topUp")
                    }
                }
            }
        },
        containerColor = Color.White
    )
}

@Composable
@Preview
fun AirtimeScreenPreview() {
    NitaTheme {
        AirtimeScreen(rememberNavController())
    }
}