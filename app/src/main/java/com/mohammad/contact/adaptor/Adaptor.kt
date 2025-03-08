package com.mohammad.contact.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.contact.R
import com.mohammad.contact.model.Model

class Adaptor (val data: ArrayList<Model>): RecyclerView.Adapter<Adaptor.ContantHolder>() {
    fun addNewContact(name: String){
        data.add(0,Model(name))
        notifyItemInserted(0)}
    inner class ContantHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val fullnameTV= itemView.findViewById<TextView>(R.id.fullname_item)
        val headTV = itemView.findViewById<TextView>(R.id.head)
        fun bindContact(model: Model,position: Int){
            fullnameTV.text = model.fullname.toString()
            headTV.text = model.fullname.substring(0,1).toString()
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"${data.get(position).fullname} removed !!!",
                    Toast.LENGTH_SHORT).show()
                data.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,data.count())

            }

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
        p0.bindContact(data.get(p1),p1

        )
    }

    override fun getItemCount(): Int{
        return data.count()
    }


}