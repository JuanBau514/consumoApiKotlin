package com.parcialii.dumi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.films.viewmodels.PetViewModel
import com.parcialii.dumi.navigation.AppNavigation
import com.ud.films.views.composable.petsList



class MainActivity : ComponentActivity() {
    private val petViewModel: PetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateView()
        }
    }

    @Composable
    fun CreateView() {
        val pets by petViewModel.mascotas.observeAsState(emptyList())
        AppNavigation(pets)
    }
}
