package com.example.films.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.veterinariaapi.repositorio.repoPet
import com.parcialii.dumi.dataClass.Pet
import kotlinx.coroutines.launch

class PetViewModel : ViewModel() {
    private val repositorioMascotas = repoPet()

    private val liveDataMascotas = MutableLiveData<List<Pet>>()
    val mascotas: LiveData<List<Pet>> = liveDataMascotas

    init {
        loadMascotas()
    }

    fun loadMascotas() {
        viewModelScope.launch {
            val pets = repositorioMascotas.getPets()
            liveDataMascotas.value = pets
        }
    }
}
