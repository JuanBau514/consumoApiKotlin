package com.parcialii.dumi.navigation

sealed class AppScreens (val route: String) {
    object MainMenu: AppScreens("main_menu")
    object AddPet: AppScreens("add_pet")
    object ViewPet: AppScreens("view_pet")
}