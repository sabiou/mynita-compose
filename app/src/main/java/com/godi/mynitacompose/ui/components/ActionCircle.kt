package com.godi.mynitacompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme

@Composable
fun ActionCircle(
    @DrawableRes iconRes: Int,
    action: String,
    isSecondType: Boolean,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .clickable(
                    onClick = onClick
                )
                .size(50.dp)
                .background(
                    shape = CircleShape,
                    color = if (!isSecondType) NitaTheme.colors.burntSienna else Color.White
                )
                .border(
                    BorderStroke(
                        1.dp,
                        if (isSecondType) NitaTheme.colors.burntSienna else Color.Transparent
                    ), shape = CircleShape
                )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconRes),
                contentDescription = "action",
                tint = if (!isSecondType) Color.White else NitaTheme.colors.burntSienna,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = action,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ActionRow(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ActionCircle(R.drawable.upward, "Envoyer", false) {
            navController.navigate("send")
        }
        ActionCircle(R.drawable.downward, "Encaisser", false, {})
        ActionCircle(R.drawable.shopping_bag, "Achat", true, {})
        ActionCircle(
            R.drawable.activity,
            "Stats",
            true,
            {}
        )
    }
}