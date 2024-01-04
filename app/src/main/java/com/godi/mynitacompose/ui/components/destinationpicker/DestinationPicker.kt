package com.godi.mynitacompose.ui.components.destinationpicker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun DestinationPricker(
    modifier: Modifier = Modifier,
    defaultSelectedDestination: Destination = getDestinations().first(),
    pickedDestination: (Destination) -> Unit,
    dialogRounded: Int = 12
) {
    val destinationsList: List<Destination> = getDestinations()
    var isPickDestination by remember { mutableStateOf(defaultSelectedDestination) }
    var isOpenDialog by remember { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.small,
        color = Color.White,
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable { isOpenDialog = true }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .size(327.dp, 56.dp)
                .padding(start = 4.dp, end = 4.dp)
                .clickable { isOpenDialog = true }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    isPickDestination.name,
                    Modifier.padding(8.dp),
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W500,
                    lineHeight = 24.sp
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = modifier
                        .padding(horizontal = 13.dp)
                )
            }
        }
    }

    // choose country dialog
    if (isOpenDialog) {
        Dialog(
            onDismissRequest = { isOpenDialog = false },
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f),
                elevation = CardDefaults.cardElevation(),
                shape = RoundedCornerShape(dialogRounded.dp)
            ) {
                Column {
                    LazyColumn {
                        items(
                            destinationsList
                        ) { destinationItem ->
                            Row(
                                Modifier
                                    .padding(
                                        horizontal = 18.dp,
                                        vertical = 18.dp
                                    )
                                    .clickable {
                                        pickedDestination(destinationItem)
                                        isPickDestination = destinationItem
                                        isOpenDialog = false
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    destinationItem.name,
                                    Modifier.padding(horizontal = 18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}