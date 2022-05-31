package com.example.newpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DiseaseViewModel(val repo : DiseaseRepository): ViewModel() {
    var diseaseList = MutableLiveData<List<Diseases>>()

    var job:Job? = null

    fun getAllDisease() {
        job = CoroutineScope(Dispatchers.IO).launch{
            val res = repo.getAllDiseases()
            if (res.isSuccessful){
                diseaseList.postValue(res.body())

            }
        }
    }
}