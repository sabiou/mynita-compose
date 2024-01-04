package com.godi.mynitacompose.navigation

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.godi.mynitacompose.R

/**
 * Sealed class representing a navigation item.
 *
 * @property route The route associated with the navigation item.
 * @property icon The icon resource ID representing the navigation item's icon.
 * @property title The title of the navigation item.
 */

sealed class NavigationItem(var route: String, @DrawableRes var iconRes: Int, var title: String) {
    object Acceuil : NavigationItem("home", R.drawable.home_svg, "Acceuil")
    object Cartes : NavigationItem("cards", R.drawable.credit_card, "Cartes")
    object Scan : NavigationItem("scan", R.drawable.qr_code_scanner, "Scan")
    object Historique : NavigationItem("history", R.drawable.minimize, "Historique")
    object Compte : NavigationItem("help", R.drawable.outline_account_circle_24, "Compte")
}