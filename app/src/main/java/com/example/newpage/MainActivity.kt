package com.example.newpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


//add dependencies
// add permissions ---internet
// 3. instance to the retrofit just like we created for the db
// 4 create the retro fit interface to give us the contract, this is where we will anotate all the requests
// 5 consuming the API endpoints, (response -> Success, error)
// 6 process and attach it to the
// endpoint is comming from a url and we place it ointo the recycler view
// put the title in a recycle view and when the user clicks on it the show the details
//
// first we workon the get request....
// .

class MainActivity : AppCompatActivity() {
    lateinit var vm :DiseaseViewModel
    var diseaseList : ArrayList<Diseases> = ArrayList()
    var adapter = DiseaseAdapter(diseaseList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var addData: Button = findViewById(R.id.add_btn)
        addData.setOnClickListener(){
            val myIntent = Intent(this,MyPostActivity::class.java)
            startActivity(myIntent)
        }

        var listView = findViewById(R.id.recyclerView) as RecyclerView

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = adapter


        val intr = RetroApiInterface.create()
        val repo = DiseaseRepository(intr)
        vm = DiseaseViewModel(repo)


        vm.diseaseList.observe(this){
            //println(it)

            adapter.setItem(it)
        }
        vm.getAllDisease()
    }

}