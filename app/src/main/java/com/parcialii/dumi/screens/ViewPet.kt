package com.parcialii.dumi.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.parcialii.dumi.R
import com.parcialii.dumi.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewPet(navController: NavController) {
    Scaffold {
        ViewPetBodyContent(navController)
    }
}

@Composable
fun ViewPetBodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            petName,
            style = TextStyle(
                fontSize = 50.sp
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.pet),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .border(1.dp, Color.Black)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Text("Age: ")
            Text(petAge)
        }


        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Text("Type pet: ")
            Text(petType)
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Text("Breed: ")
            Text(petBreed)
        }


        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        }) {
            Text(text = "Go to list")
        }
    }
}