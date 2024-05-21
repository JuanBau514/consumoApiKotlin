package com.ud.films.views.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.parcialii.dumi.dataClass.Pet

@Composable
fun petsList(pets: List<Pet>) {
    LazyColumn {
        items(pets) { pet ->
            petsItem(pet = pet)
        }
    }
}
@Composable
fun petsItem(pet: Pet) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Type: ${pet.type}", color = Color.Green)
        Text(text = "Name: ${pet.name}", color = Color.Green)
        Text(text = "Age: ${pet.age.toString()}", color = Color.Green)
        Text(text = "Breed: ${pet.breed}", color = Color.Green)
    }
}