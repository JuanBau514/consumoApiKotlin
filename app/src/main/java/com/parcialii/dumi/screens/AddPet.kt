package com.parcialii.dumi.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.films.viewmodels.PetViewModel
import com.example.films.viewmodels.valueCB
import com.parcialii.dumi.dataClass.Pet
import com.parcialii.dumi.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddPet(navController: NavController, petViewModel: PetViewModel) {
    Scaffold {
        AddPetBodyContent(navController, petViewModel)
    }
}

@Composable
fun AddPetBodyContent(navController: NavController, petViewModel: PetViewModel) {
    var petname by remember { mutableStateOf(TextFieldValue("")) }
    var age by remember { mutableStateOf(TextFieldValue("")) }
    var valueT by remember { mutableStateOf("") }
    var valueB by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Store the pet")

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Name")
        TextField(
            value = petname,
            onValueChange = { petname = it },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Type the pet name") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Type of pet")
        ComboBox(lista = type)
        valueT= valueCB

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Age (in months)")
        TextField(
            value = age,
            onValueChange = { age = it },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Type the age of the pet") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Breed")
        ComboBox(lista = breed)
        valueB = valueCB

        Button(onClick = {
            val newPet = Pet(
                name = petname.text,
                type = valueT,
                age = age.text.toIntOrNull() ?: 0,
                breed = valueB,
                image = "1716173042472.jpg"
            )
            petViewModel.savePet(newPet)
            navController.navigate(route = AppScreens.MainMenu.route)
        }) {
            Text(text = "Save")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        }) {
            Text(text = "Cancel")
        }
    }
}

class MainActivity : ComponentActivity() {
    private val petViewModel: PetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}