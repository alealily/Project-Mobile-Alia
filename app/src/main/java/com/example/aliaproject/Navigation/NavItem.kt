package com.example.aliaproject.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItem = listOf(
    NavItem(
        label = "Beranda",
        icon = Icons.Default.Home,
        route = Screen.Home.name
    ),
    NavItem(
        label = "List",
        icon = Icons.Default.Menu,
        route = Screen.List.name
    ),
    NavItem(
        label = "About",
        icon = Icons.Default.Person,
        route = Screen.About.name
    )
)
