package com.example.aeropuerto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val button = findViewById<Button>(R.id.button)
        spinner1.setSelection(-1)
        spinner2.setSelection(-1)
        val lista1 = arrayOf("Asia", "Europa", "América", "África", "Oceanía")

        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1)
        spinner1.adapter = adaptador
        val secondAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, emptyList())
            spinner2.adapter = secondAdapter
       spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position) as String
                val options = when (selectedItem) {
                    "Asia" -> listOf("China Airlines", "Fly Emirates", "Indian Air ")
                    "Europa" -> listOf("Lan", "Deustchlan", "Norway Airlines")
                    "África" -> listOf("Tanzania Air", "Southafrican Air", "Egypt Airlines")
                    "América" -> listOf("Aero México", "Air Bus", "Latam")
                    "Oceanía" -> listOf("Australian Travelers", "Islandian Adventure")
                    else -> emptyList()
                }
                val newAdapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_item, options)
                spinner2.adapter = newAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No se seleccionó ningún elemento
            }
        }


        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                button.isEnabled = true
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                button.isEnabled = false
            }
        }

        val intent = Intent(this, Cantidad::class.java)

        button.setOnClickListener {
            val dato1 = spinner1.getItemAtPosition(spinner1.selectedItemPosition) as String
            val dato2 = spinner2.getItemAtPosition(spinner2.selectedItemPosition) as String
            val dato3= dato1 +","+dato2
            intent.putExtra("DATO1", dato3)
            startActivity(intent)
        }

    }
}