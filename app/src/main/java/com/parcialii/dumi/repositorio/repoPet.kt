package com.example.veterinariaapi.repositorio

import com.example.veterinariaapi.Network.PetsApi
import com.example.veterinariaapi.Network.RetrofitClient
import com.parcialii.dumi.dataClass.Pet
import retrofit2.Response

class repoPet {
    private val petApi: PetsApi = RetrofitClient.petsApi

    suspend fun getPets(sortBy: String?, type: String?, breed: String?, age: Int?, name: String?) : List<Pet> {
        return petApi.getPets(sortBy, type, breed, age, name)
    }

    suspend fun  savePet(pet: Pet) : Response<Void> {
        return petApi.savePet(pet)
    }
}