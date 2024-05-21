package com.example.veterinariaapi.Network
import com.parcialii.dumi.dataClass.Pet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PetsApi {
        @GET("/pets/filter")
        suspend fun getPets(
                @Query("sortBy") sortBy: String?,
                @Query("type") type: String?,
                @Query("breed") breed: String?,
                @Query("age") age: Int?,
                @Query("name") name: String?
        ): List<Pet>

        @POST("/pets")
        suspend fun savePet(@Body pet: Pet): Response<Void>
}