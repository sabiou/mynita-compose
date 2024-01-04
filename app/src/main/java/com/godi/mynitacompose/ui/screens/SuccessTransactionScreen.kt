package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.navigation.NavigationItem
import com.godi.mynitacompose.ui.theme.NitaTheme

@Composable
fun SuccessScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(navController)
        },
        content = { padding ->
            Column(
                modifier = modifier
                    .padding(padding)
                    .padding(start = 40.dp, end = 40.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.check_circle_24),
                    contentDescription = "",
                    modifier = Modifier.size(150.dp),
                    tint = Color.White
                )
                Text(
                    text = "Votre transaction a ete effectuée avec success",
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(280.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 16.dp)
                        )
                        .padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 24.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Text(
                                    text = "ID Transaction",
                                    fontWeight = FontWeight.Bold,
                                    color = NitaTheme.colors.burntSienna
                                )
                                Text(
                                    text = "1003760097654",
                                    color = Color.Gray
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Text(
                                    text = "Code d'envoi",
                                    fontWeight = FontWeight.Bold,
                                    color = NitaTheme.colors.burntSienna
                                )
                                Text(
                                    text = "NT76009764",
                                    color = Color.Gray
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        }
                        Divider(thickness = Dp.Hairline)
                        Column {
                            Text(
                                text = "Destinataire",
                                fontWeight = FontWeight.Bold,
                                color = NitaTheme.colors.burntSienna
                            )
                            Text(
                                text = "Farouk Sabiou",
                                color = Color.Gray,
                            )
                        }
                        Divider(thickness = Dp.Hairline)
                        Column {
                            Text(
                                text = "Destination",
                                fontWeight = FontWeight.W600,
                                color = NitaTheme.colors.burntSienna
                            )
                            Text(
                                text = "Niamey",
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        },
        containerColor = NitaTheme.colors.burntSienna
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavController
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
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavigationItem.Acceuil.route)
                        }
                        .size(40.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
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
fun SuccessTransactionScreenPreview() {
    NitaTheme {
        SuccessScreen(navController = rememberNavController())
    }
}