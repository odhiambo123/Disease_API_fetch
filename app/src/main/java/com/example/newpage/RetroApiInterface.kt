package com.example.newpage

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroApiInterface {

    //singleton ====> doing the same we did for the data base in the earlier project
    @GET("main.json")
    suspend fun getAllDiseases() : Response<List<Diseases>>//No type arguments expected for class Call

    companion object{
        var BASE_URL = "https://odhiambo123.github.io/Diseases/"
        fun create() : RetroApiInterface{
            //builder factory then build it ---
            // Retrofit will provide the builder
            val retrofit =  Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                BASE_URL).build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}