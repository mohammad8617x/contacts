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
    lateinit var recycler : RecyclerView
    lateinit var adaptor: Adaptor
    lateinit var layoutManager: LinearLayoutManager
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  data = listOf(
            Model("mohammad"),
            Model("hasan")
        )
        adaptor = Adaptor(data)
        recycler = binding.items
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recycler.adapter = adaptor
        recycler.layoutManager = layoutManager

    }
}