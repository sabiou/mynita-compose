package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme
import com.godi.mynitacompose.utils.formatCurrency

@Composable
fun SendMoneyScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NumPad(navController)
            }
        },
        containerColor = NitaTheme.colors.cobaltBlue
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NumPad(
    navController: NavController,
) {
    val controller = LocalSoftwareKeyboardController.current
    var amount by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val maxChar = 8
        controller?.hide()
        TextField(
            value = formatCurrency(amount),
            onValueChange = {
                if (it.length <= maxChar) amount = it
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = NitaTheme.colors.cobaltBlue,
                unfocusedContainerColor = NitaTheme.colors.cobaltBlue,
                disabledContainerColor = NitaTheme.colors.cobaltBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            textStyle = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.W900,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(
                        R.font.exo_bold
                    )
                ),
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            maxLines = 1,
            keyboardActions = KeyboardActions(
                onNext = KeyboardActions.Default.onNext
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            PadButton(
                1, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 1
                }
            }
            PadButton(
                2, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 2
                }
            }
            PadButton(
                3, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 3
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            PadButton(
                4, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 4
                }
            }
            PadButton(
                5, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 5
                }
            }
            PadButton(
                6, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 6
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            PadButton(
                7, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 7
                }
            }
            PadButton(
                8, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 8
                }
            }
            PadButton(
                9, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 9
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            CommaButton(
                background = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {}
            PadButton(
                0, backgroundColor = NitaTheme.colors.cobaltBlue,
                textColor = Color.White
            ) {
                if (amount.length < maxChar) {
                    amount += 0
                }
            }
            DeleteButton(
                backgroundColor = NitaTheme.colors.cobaltBlue,
                iconTint = Color.White
            ) {
                if (amount.isNotEmpty()) amount = amount.dropLast(1)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier
                .size(200.dp, 50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                NitaTheme.colors.burntSienna
            ),
            onClick = {
                navController.navigate("recipientDetails/${amount}")
            }
        ) {
            Text(
                text = "Envoyer",
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.exo_bold)
                ),
            )
        }
    }
}