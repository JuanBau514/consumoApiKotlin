package com.parcialii.dumi.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.parcialii.dumi.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddPet(navController: NavController) {
    Scaffold {
        AddPetBodyContent(navController)
    }
}

@Composable
fun AddPetBodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Storage the pet")

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Name")

        var petname by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = petname,
            onValueChange = { newText ->
                petname = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Type the pet name") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Type of pet")

        ComboBox(lista = type)

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Age (in months)")

        var age by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = age,
            onValueChange = { newText ->
                age = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Type the age of the pet") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Breed")

        ComboBox(lista = breed)

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Photo")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                navController.navigate(route = AppScreens.MainMenu.route)
            }) {
                Text(text = "Save")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {
                navController.navigate(route = AppScreens.MainMenu.route)
            }) {
                Text(text = "Cancel")
            }
        }
    }
}