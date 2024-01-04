package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.godi.mynitacompose.ui.components.MasterCardDigitalCard
import com.godi.mynitacompose.ui.components.NetflixDigitalCard
import com.godi.mynitacompose.ui.components.TotalDigitalCard
import com.godi.mynitacompose.ui.components.VisaDigitalCard
import com.godi.mynitacompose.ui.theme.NitaTheme

@Composable
fun CardsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
        },
        content = { padding ->
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Text(
                        text = "Cartes",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 36.sp,
                    )
                    CardsPager()
                }
            }
        },
        containerColor = Color.White
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardsPager() {
    Box(
        modifier = Modifier
            .background(Color(0xFFECECEC)),
        contentAlignment = Alignment.Center
    ) {
        val pagerState = rememberPagerState(pageCount = { 4 })
        HorizontalPager(
            pageSpacing = 8.dp,
            state = pagerState,
        ) { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                MasterCardDigitalCard(pagerState = pagerState, page = page)
            }

        }
    }
}


@Composable
@Preview
fun CardsScreenPreview() {
    NitaTheme {
        CardsPager()
    }
}