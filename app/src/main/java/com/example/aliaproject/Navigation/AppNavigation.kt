package com.example.aliaproject.Navigation

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aliaproject.R
import com.example.aliaproject.Screen.About
import com.example.aliaproject.Screen.Detail
import com.example.aliaproject.Screen.Home
import com.example.aliaproject.Screen.List
import com.example.aliaproject.ui.theme.TopBar

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(navController: NavController, paddingValues: PaddingValues) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val title = when (currentRoute) {
        Screen.Home.name -> "Beranda"
        Screen.List.name -> "List"
        Screen.About.name -> "About"
        else -> "Detail"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title, fontFamily = Serif, fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "$title", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "logo",
                            tint = Color.Unspecified)
                    }
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TopBar,
                    titleContentColor = Color.Black)
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItem.forEach { navItem: NavItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = Screen.Home.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.Home.name) {
                val context = LocalContext.current
                Home(context, navController)
            }
            composable(route = Screen.List.name) {
                val context = LocalContext.current
                List(context, navController)
            }
            composable(route = Screen.About.name) {
                About()
            }
            composable(
                route = "detail/{itemName}"
            ){ navBackStackEntry ->
                val itemName = navBackStackEntry.arguments?.getString("itemName") ?: "Unknow"
                Detail(itemName = itemName, navController = navController)

            }
        }
    }
}
