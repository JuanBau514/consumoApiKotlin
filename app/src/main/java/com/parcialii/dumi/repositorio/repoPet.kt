package com.example.veterinariaapi.repositorio

import com.example.veterinariaapi.Network.PetsApi
import com.example.veterinariaapi.Network.RetrofitClient
import com.parcialii.dumi.dataClass.Pet

class repoPet {
    private val petApi: PetsApi = RetrofitClient.petsApi

    suspend fun getPets() : List<Pet> {
        return petApi.getPets()
    }
}