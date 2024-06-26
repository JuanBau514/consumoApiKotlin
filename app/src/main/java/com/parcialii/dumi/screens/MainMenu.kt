package com.parcialii.dumi.screens

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.parcialii.dumi.dataClass.Pet
import com.parcialii.dumi.navigation.AppScreens
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.films.viewmodels.PetViewModel
import com.example.films.viewmodels.valueCB
import com.parcialii.dumi.MainActivity


val order = listOf("type", "name", "age", "breed")
val type = listOf("Dog", "Cat")
val breed = listOf("Bulldog", "Labrador", "Pitbull", "Mixed-breed", "Angora")
var petName = ""
var petType = ""
var petBreed = ""
var petAge = ""



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun MainMenu(navController: NavController, pets: List<Pet>) {
    Scaffold {
        MainMenuBodyContent(navController, pets)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuBodyContent(navController: NavController, pets: List<Pet>) {
    var query by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Order by:")
            ComboBox(lista = order)
        }

        Spacer(modifier = Modifier.height(30.dp))

        SearchBar(
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = {
            },
            active = false,
            onActiveChange = {
            },
            placeholder = { Text(text = "Search by name of pet") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        )
        {
        }
        Spacer(modifier = Modifier.height(30.dp))
        if (query.isEmpty()) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PetList(navController, AppScreens.ViewPet.route, pets)
            }
        } else {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val filteredPets = pets.filter { it.name.contains(query, true) }
                PetList(navController = navController, AppScreens.ViewPet.route, filteredPets)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(route = AppScreens.AddPet.route)
        }) {
            Text(text = "Add Pet")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboBox(lista: List<String>) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedText by remember {
        mutableStateOf(valueCB)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = !isExpanded
            }
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = {
                },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                }
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                }
            )
            {
                lista.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {
                            Text(text = text)
                        },
                        onClick = {
                            selectedText = lista[index]
                            valueCB = lista[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Composable
fun PetList(navController: NavController, route: String, pets: List<Pet>) {
    LazyColumn(
        modifier = Modifier
            .height(300.dp)
            .width(600.dp)
            .padding(10.dp)
            .border(1.dp, Color.Black)
    ) {
        items(pets) { pet ->
            PetListItem(
                onClick = {
                    navController.navigate(route = route)
                    petName = pet.name
                    petType = pet.type
                    petBreed = pet.breed
                    petAge = pet.age.toString()
                }, pet = pet)
        }
    }
}

@Composable
fun PetListItem(onClick:
                    () -> Unit, pet: Pet) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = pet.name,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Text(
            text = pet.type,
            modifier = Modifier.padding(start = 8.dp),
            style = TextStyle(
                fontSize = 10.sp
            )
        )
    }
}