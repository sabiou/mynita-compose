package com.godi.mynitacompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme
import com.godi.mynitacompose.utils.formatCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopUpDetailsScreen(
    navController: NavController
) {
    val backStackEntry = navController.currentBackStackEntry
    val arguments = backStackEntry?.arguments
    val amount = arguments?.getString("amount")

    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var isPhoneNumberEmpty by rememberSaveable { mutableStateOf(true) }
    var isDescriptionEmpty by rememberSaveable { mutableStateOf(true) }
    var recurrenceChip by rememberSaveable { mutableStateOf(false) }

    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    var confirmBottomSheetVisible by rememberSaveable { mutableStateOf(false) }

    if (confirmBottomSheetVisible) {
        ConfirmTopUpBottomSheet(
            navController,
            onConfirm = {
            },
        ) {
            confirmBottomSheetVisible = false
        }
    }

    Scaffold(
        topBar = {
            MyNitaTopBar(hasTitle = true, titleStringId = R.string.achat_credit)
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Numero de telephone",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.niger_flag
                                ),
                                contentScale = ContentScale.FillBounds,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .size(24.dp),
                            )
                            Text(
                                text = "+227", fontSize = 18.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 24.sp,
                                fontFamily = FontFamily(Font(R.font.exo_regular))
                            )
                        }
                    },
                    value = phoneNumber,
                    onValueChange = { phone ->
                        phoneNumber = phone
                        isPhoneNumberEmpty = phone.isEmpty()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NitaTheme.colors.burntSienna,
                        unfocusedBorderColor = Color.LightGray,
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Description",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = description,
                    onValueChange = { desc ->
                        description = desc
                        isDescriptionEmpty = desc.isEmpty()
                    },
                    placeholder = {
                        Text(text = "Optionel")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NitaTheme.colors.burntSienna,
                        unfocusedBorderColor = Color.LightGray,
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .toggleable(
                            value = checkedState,
                            onValueChange = { onStateChange(!checkedState) },
                            role = Role.Checkbox
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null,
                        colors = CheckboxDefaults.colors(
                            NitaTheme.colors.burntSienna,
                            uncheckedColor = NitaTheme.colors.burntSienna,
                            disabledUncheckedColor = Color.White,
                        )
                    )
                    Text(
                        text = "Achat recurent",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Text(
                    text = "Choisissez une frequence",
                    style = MaterialTheme.typography.bodyLarge,
                    color = NitaTheme.colors.cobaltBlue,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = recurrenceChip,
                        label = {
                            Text(
                                text = "Journalier",
                                fontFamily = FontFamily(Font(R.font.exo_regular))
                            )
                        },
                        onClick = { recurrenceChip = !recurrenceChip },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = NitaTheme.colors.burntSienna,
                            selectedLabelColor = Color.White,
                        ),
                    )
                    FilterChip(
                        selected = recurrenceChip,
                        label = {
                            Text(
                                text = "Hebdomadaire",
                                fontFamily = FontFamily(Font(R.font.exo_regular))
                            )
                        },
                        onClick = { recurrenceChip = !recurrenceChip },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = NitaTheme.colors.burntSienna,
                            selectedLabelColor = Color.White,
                        ),
                    )
                    FilterChip(
                        selected = recurrenceChip,
                        label = {
                            Text(
                                text = "Mensuel",
                                fontFamily = FontFamily(Font(R.font.exo_regular))
                            )
                        },
                        onClick = { recurrenceChip = !recurrenceChip },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = NitaTheme.colors.burntSienna,
                            selectedLabelColor = Color.White,
                        ),
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { confirmBottomSheetVisible = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        NitaTheme.colors.burntSienna
                    )
                ) {
                    Text(
                        text = "Continuer",
                        fontFamily = FontFamily(Font((R.font.exo_bold))),
                        fontSize = 18.sp
                    )
                }
            }
        },
        containerColor = Color.White
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmTopUpBottomSheet(
    navController: NavController,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = NitaTheme.colors.burntSienna
    ) {
        Column(
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = "Confirmation",
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                color = Color.White
            )
            ConfirmationRow(
                description = "Vous achetez",
                text = formatCurrency("1000")
            )
            ConfirmationRow(
                description = "Numero de telephone",
                text = "89450004"
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        onConfirm()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(311.dp, 56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        NitaTheme.colors.cobaltBlue
                    )
                ) {
                    Text(text = "Confirmer achat")
                }
            }
        }
    }
}

@Composable
@Preview
fun TopUpDetailsScreenPreview() {
    NitaTheme {
        TopUpDetailsScreen(rememberNavController())
    }
}