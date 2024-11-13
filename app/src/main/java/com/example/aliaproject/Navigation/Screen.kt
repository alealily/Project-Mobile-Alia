package com.example.aliaproject.Navigation

sealed class Screen(val name: String) {
    object Home : Screen("home")
    object List : Screen("list")
    object About : Screen("about")
}

