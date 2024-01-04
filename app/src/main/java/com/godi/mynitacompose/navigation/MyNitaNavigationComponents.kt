package com.godi.mynitacompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.godi.mynitacompose.R
import com.godi.mynitacompose.ui.theme.NitaTheme

/**
 * Composable function for the custom bottom navigation bar in the Remit app.
 *
 * @param navController The NavController instance for handling navigation.
 */
@Composable
fun MyNitaBottomBar(
    navController: NavController
) {
    val items = listOf(
        NavigationItem.Acceuil,
        NavigationItem.Cartes,
        NavigationItem.Scan,
        NavigationItem.Historique,
        NavigationItem.Compte
    )
    MyNitaNavigationBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEachIndexed { index, item ->
            val isScanButton = index == 2
            MyNitaNavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    if (isScanButton) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .background(
                                    color = NitaTheme.colors.stealBlue,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = ImageVector.vectorResource(item.iconRes),
                                contentDescription = item.title,
                                tint = Color.White
                            )
                        }
                    } else {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ImageVector.vectorResource(item.iconRes),
                            contentDescription = item.title,
                        )
                    }
                },
                selectedIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.iconRes),
                        contentDescription = item.title,
                    )
                },
                label = {
                    if (!isScanButton) Text(text = item.title) else Text(text = "")
                },
            )
        }

    }
}