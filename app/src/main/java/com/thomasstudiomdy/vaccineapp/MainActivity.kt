package com.thomasstudiomdy.vaccineapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // AdapterView: RecyclerView
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        // Data Source
        var vaccinesList:ArrayList<VaccineModel> = generateData()

        // Adapter
        val adapter = MyAdapter(vaccinesList)

        recyclerView.adapter = adapter

    }

    private fun generateData():ArrayList<VaccineModel>{
        val vaccines = ArrayList<VaccineModel>()
        vaccines.add(VaccineModel("Covid-19",R.drawable.vaccine1))
        vaccines.add(VaccineModel("Hepatitis B Vaccine",R.drawable.vaccine2))
        vaccines.add(VaccineModel("Tatanus Vaccine",R.drawable.vaccine3))
        vaccines.add(VaccineModel("Pnenumococal Vaccine",R.drawable.vaccine4))
        vaccines.add(VaccineModel("Rotavirus Vaccine",R.drawable.vaccine5))
        vaccines.add(VaccineModel("Measles Vaccine",R.drawable.vaccine6))
        vaccines.add(VaccineModel("Chickenpox Vaccine",R.drawable.vaccine7))
        vaccines.add(VaccineModel("HPV Vaccine",R.drawable.vaccine8))
        vaccines.add(VaccineModel("Diphtheria Vaccine",R.drawable.vaccine9))
        vaccines.add(VaccineModel("RSV Vaccine",R.drawable.vaccine10))
        return vaccines
    }
}