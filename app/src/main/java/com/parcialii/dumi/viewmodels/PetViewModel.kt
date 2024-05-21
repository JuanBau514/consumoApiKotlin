package com.example.films.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.veterinariaapi.repositorio.repoPet
import com.parcialii.dumi.dataClass.Pet
import kotlinx.coroutines.launch

var valueCB = "type"
class PetViewModel : ViewModel() {
    private val repositorioMascotas = repoPet()

    private val liveDataMascotas = MutableLiveData<List<Pet>>()
    val mascotas: LiveData<List<Pet>> = liveDataMascotas

    init {
        loadMascotas()
    }

    fun loadMascotas() {
        viewModelScope.launch {
            val pets = repositorioMascotas.getPets(sortBy= valueCB, type = null, breed=null, age = null, name= null)
            liveDataMascotas.value = pets
        }
    }

    fun savePet(pet: Pet){
        viewModelScope.launch {
            repositorioMascotas.savePet(pet)
        }
    }
}
