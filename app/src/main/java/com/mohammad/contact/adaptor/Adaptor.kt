package com.mohammad.contact.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.contact.R
import com.mohammad.contact.model.Model

class Adaptor (val data: List<Model>): RecyclerView.Adapter<Adaptor.ContantHolder>() {

    inner class ContantHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val fullnameTV= itemView.findViewById<TextView>(R.id.fullname)
        val headTV = itemView.findViewById<TextView>(R.id.head_item)
        fun bindContact(model: Model){
            fullnameTV.text = model.fullname
            headTV.text = model.fullname.substring(0,1).toString()
        }
    }
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): ContantHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.example_one_item,null)
       return ContantHolder(view)
    }

    override fun onBindViewHolder(
        p0: ContantHolder,
        p1: Int
    ) {
        p0.bindContact(data[p1])
    }

    override fun getItemCount(): Int{
        return data.count()
    }


}