package com.example.recycle1

import CountryAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val countries = listOf("India" , "Usa" , "Canada" ,"Australia" , "Germany" ,
            "France" , "Italy" , "Spain" , "Japan" , "China" , "Brazil" , "Russia" ,
            "United Kingdom" , "South Korea" , "Mexico" , "Indonesia" , "Nigeria" , "Egypt" , "Turkey" ,
            "South Africa" , "South Korea" , "Mexico" , "Indonesia" , "Nigeria" , "Egypt" , "Turkey")


        recyclerView = findViewById(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(countries)

    }
}