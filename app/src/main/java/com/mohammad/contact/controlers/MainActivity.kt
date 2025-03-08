package com.mohammad.contact.controlers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.contact.R
import com.mohammad.contact.adaptor.Adaptor
import com.mohammad.contact.databinding.ActivityMainBinding
import com.mohammad.contact.model.Model


class MainActivity :AppCompatActivity() {

    lateinit var adaptor: Adaptor
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
binding.btnadditem.setImageResource(R.drawable.baseline_add_white_24)

        adaptor = Adaptor(arrayListOf(
            Model("mohammad"),
            Model("hasan")
        ))

        binding.items.adapter = adaptor
        binding.items.layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.btnadditem.setOnClickListener {
            if (binding.textfullname.length()>0){
                adaptor.addNewContact(binding.textfullname.text.toString())
                binding.items.scrollToPosition(0)
                binding.textfullname.setText("")
            }
        }

    }
}