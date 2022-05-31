package com.example.newpage

class DiseaseRepository(val inter : RetroApiInterface) {
    suspend fun getAllDiseases() = inter.getAllDiseases()
}