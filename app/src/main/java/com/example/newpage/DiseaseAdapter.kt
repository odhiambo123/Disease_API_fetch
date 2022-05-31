package com.example.newpage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call

class DiseaseAdapter(/*private var onCardClick: (position:Int) -> Unit,*/ private var diseaseList:List<Diseases>):RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.disease_list_layout, parent, false)
        return ViewHolder(view/*, onCardClick*/)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemVM = diseaseList[position]
        holder.id.text = itemVM.id.toString()
        holder.name.text = itemVM.name
        holder.date_updated_at.text = itemVM.data_updated_at
        holder.symptoms.text = itemVM.symptoms
        holder.facts.text = itemVM.facts.toString()
    }
    fun setItem(diseaseList : List<Diseases>){
        this.diseaseList = diseaseList

        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return diseaseList.size
    }

    }


class ViewHolder(view: View/*, private val onCardClick: (position: Int) -> Unit*/):RecyclerView.ViewHolder(view)/*, View.OnClickListener*/ {
    /*init {
        itemView.setOnClickListener(this)
    }*/
    val id : TextView = view.findViewById(R.id.disease_id)!!
    val name : TextView = view.findViewById(R.id.new_name)
    val date_updated_at : TextView = view.findViewById(R.id.date_updated_at)
    val symptoms : TextView = view.findViewById(R.id.disease_symptoms)

    val facts : TextView = view.findViewById(R.id.disease_facts)
    /*override fun onClick(v: View?) {
        val position = adapterPosition
        onCardClick(position)
    }
*/

}