package com.parcialii.dumi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.parcialii.dumi.dataClass.Pet
import com.parcialii.dumi.screens.AddPet
import com.parcialii.dumi.screens.MainMenu
import com.parcialii.dumi.screens.ViewPet

@Composable
fun AppNavigation(pets: List<Pet>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainMenu.route) {
        composable(route = AppScreens.MainMenu.route) {
            MainMenu(navController, pets)
        }
        composable(route = AppScreens.AddPet.route) {
            AddPet(navController)
        }
        composable(route = AppScreens.ViewPet.route) {
            ViewPet(navController)
        }
    }
}