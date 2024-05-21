package com.example.veterinariaapi.Network
import com.parcialii.dumi.dataClass.Pet
import retrofit2.http.GET
import retrofit2.http.POST

interface PetsApi {
        @GET("pets")
        suspend fun getPets(): List<Pet>

        @POST("pets")
        suspend fun save(): Pet
}