package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme
import com.godi.mynitacompose.utils.formatCurrency

@Composable
fun NumPadTopUpScreen(
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
                NumericPad(navController)
            }
        },
        containerColor = Color.White
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NumericPad(
    navController: NavController,
) {
    val controller = LocalSoftwareKeyboardController.current
    var amount by rememberSaveable { mutableStateOf("") }
    var isAmountFieldEmpty by rememberSaveable { mutableStateOf(true) }
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
                isAmountFieldEmpty = it.isEmpty()
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            textStyle = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.W900,
                color = NitaTheme.colors.burntSienna,
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
            PadButton(1,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 1
                }
            }
            PadButton(2,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 2
                }
            }
            PadButton(3,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 3
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            PadButton(4,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 4
                }
            }
            PadButton(5,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 5
                }
            }
            PadButton(6,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 6
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            PadButton(7,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 7
                }
            }
            PadButton(8,backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 8
                }
            }
            PadButton(9, backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna) {
                if (amount.length < maxChar) {
                    amount += 9
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            CommaButton(
                background = Color.White,
                textColor = NitaTheme.colors.burntSienna
            ) {}
            PadButton(
                0,
                backgroundColor = Color.White,
                textColor = NitaTheme.colors.burntSienna
            ) {
                if (amount.length < maxChar) {
                    amount += 0
                }
            }
            DeleteButton(
                backgroundColor = Color.White,
                iconTint = NitaTheme.colors.burntSienna
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
                navController.navigate("topUpDetails/$amount")
            },
        ) {
            Text(
                text = "Continuer",
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.exo_bold)
                ),
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
        }
    }
}

@Composable
fun DeleteButton(
    backgroundColor: Color,
    iconTint: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .offset(x = 0.dp, y = 0.dp)
            .size(64.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(top = 14.dp, bottom = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Backspace,
            contentDescription = "delete",
            tint = iconTint
        )
    }
}

@Composable
fun PadButton(
    number: Int,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .offset(x = 0.dp, y = 0.dp)
            .size(64.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(top = 14.dp, bottom = 14.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "$number",
            style = TextStyle(
                fontSize = 28.sp,
                lineHeight = 36.4.sp,
                fontWeight = FontWeight(700),
                color = textColor,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(
                        R.font.exo_bold
                    )
                )
            )
        )
    }
}

@Composable
fun CommaButton(
    background: Color,
    textColor: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .size(64.dp)
            .background(
                color = background,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(top = 14.dp, bottom = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = ".",
            style = TextStyle(
                fontSize = 28.sp,
                lineHeight = 36.4.sp,
                fontWeight = FontWeight(700),
                color = textColor,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.exo_bold))
            )
        )
    }
}

@Composable
@Preview
fun NumPadTopUpScreenPreview() {
    MaterialTheme {
        NumPadTopUpScreen(navController = rememberNavController())
    }
}