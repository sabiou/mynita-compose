@file:OptIn(ExperimentalFoundationApi::class)

package com.godi.mynitacompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme
import com.godi.mynitacompose.utils.formatCurrency
import kotlin.math.absoluteValue

@Composable
fun VisaDigitalCard(
    pagerState: PagerState,
    page: Int,
) {
    val gradientBrush = Brush.linearGradient(
        listOf(
            NitaTheme.colors.cobaltBlue, NitaTheme.colors.cobaltBlue ,NitaTheme.colors.burntSienna,
        ),
        start = Offset(50f, -100f),
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .width(290.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = gradientBrush)
    ) {
        val pageOffset = (
                (pagerState.currentPage - page) + pagerState
                    .currentPageOffsetFraction
                ).absoluteValue
        Column(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, bottom = 24.dp, end = 12.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        // get a scale value between 1 and 1.75f, 1.75 will be when its resting,
                        // 1f is the smallest it'll be when not the focused page
                        val scale = lerp(1f, 1.75f, pageOffset)
                        // apply the scale equally to both X and Y, to not distort the image
                        scaleX = scale
                        scaleY = scale
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.visa_logo),
                    contentDescription = "",
                )
                Icon(
                    painter = painterResource(R.drawable.sim),
                    contentDescription = "",
                    tint = Color(0xFFD4AF37)
                )
            }
            Text(
                text = "xxxx xxxx xxxx 4530",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.6.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 2.2.sp,
                    fontFamily = FontFamily(Font(R.font.exo_regular))
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "FAROUK SABIOU",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.LightGray,
                    )

                )
                Text(
                    text = "11/26",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.exo_regular)),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }
    }
}

@Composable
fun MasterCardDigitalCard(
    pagerState: PagerState,
    page: Int,
) {
    val gradientBrush = Brush.linearGradient(
        listOf(
            NitaTheme.colors.forestGreen, Color.Black
        ),
        start = Offset(0f, 50f),
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .width(290.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, bottom = 24.dp, end = 12.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier.size(50.dp, 40.dp),
                    painter = painterResource(R.drawable.mc_symbol),
                    contentDescription = "",
                )
                Icon(
                    painter = painterResource(R.drawable.sim),
                    contentDescription = "",
                    tint = Color(0xFFD4AF37)
                )
            }
            Text(
                text = "xxxx xxxx xxxx 4530",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.6.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 2.2.sp,
                    fontFamily = FontFamily(Font(R.font.exo_regular))
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "FAROUK SABIOU",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.LightGray,
                    )

                )
                Text(
                    text = "11/26",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.exo_regular)),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }
    }
}

@Composable
fun TotalDigitalCard(
    pagerState: PagerState,
    page: Int,
) {
    val gradientBrush = Brush.linearGradient(
        listOf(
            Color.White, Color.Gray, Color.Gray, Color.Gray, Color.LightGray
        ),
        start = Offset(-10f, 100f),
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .width(290.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, bottom = 24.dp, end = 12.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier.size(50.dp, 40.dp),
                    painter = painterResource(R.drawable.total_logo),
                    contentDescription = "",
                )
                Icon(
                    painter = painterResource(R.drawable.sim),
                    contentDescription = "",
                    tint = Color(0xFFD4AF37)
                )
            }
            Text(
                text = "xxxx xxxx xxxx 4530",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.6.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = 2.2.sp,
                    fontFamily = FontFamily(Font(R.font.exo_regular))
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "FAROUK SABIOU",
                    style = TextStyle(
                        fontSize = 12.sp,
                    )

                )
                Text(
                    text = formatCurrency("100000"),
                    style = TextStyle(
                        fontSize = 12.sp,
                    )
                )
            }
        }
    }
}

@Composable
fun NetflixDigitalCard(
    pagerState: PagerState,
    page: Int,
) {
    val gradientBrush = Brush.linearGradient(
        listOf(
        ),
        start = Offset(-10f, 100f),
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .width(290.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, bottom = 24.dp, end = 12.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier.size(40.dp, 40.dp),
                    painter = painterResource(R.drawable.netflix),
                    contentDescription = "",
                )
                Icon(
                    modifier = Modifier.size(30.dp, 30.dp),
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "NETFLIX",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White,
                    )

                )
                Text(
                    text = formatCurrency("20000"),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
@Preview
fun DigitalCardPreview() {
    NitaTheme {

    }
}