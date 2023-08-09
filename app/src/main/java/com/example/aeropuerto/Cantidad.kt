package com.example.aeropuerto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Cantidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cantidad)

        val dato = intent.getStringExtra("DATO1")
        val alert = findViewById<TextView>(R.id.alert)
        val sp1 = findViewById<Spinner>(R.id.sp1)
        val sp2 = findViewById<Spinner>(R.id.sp2)
        val button = findViewById<Button>(R.id.button2)
        val RG = findViewById<RadioGroup>(R.id.RG)
        val kg = findViewById<EditText>(R.id.kg)
        val lista1 = arrayOf("1", "2", "3", "4")
        val lista2 = arrayOf("0","1", "2", "3", "4")
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1)
        val adaptador2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista2)
        sp1.adapter = adaptador
        sp2.adapter = adaptador2
        var flag = 0;

        RG.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.si -> {kg.isEnabled = true
                    flag = 1}
                R.id.no ->{kg.isEnabled = false
                    flag = 0}
            }
        }
        val intent = Intent(this, Pais::class.java)


        button.setOnClickListener {
            val dato1 = sp1.getItemAtPosition(sp1.selectedItemPosition) as String
            val dato2 = sp2.getItemAtPosition(sp2.selectedItemPosition) as String
            var dato3 = kg.text.toString()
            var dato4 =""
            val texto = kg.text.toString()
            var entero  = texto.toIntOrNull()

            when(flag){
                0 -> { dato3="0"
                    dato4 = dato + "," + dato1 + "," + dato2 + "," + dato3
                    intent.putExtra("DATO2", dato4)
                    startActivity(intent)}
                1 -> {if (entero != null) {
                    if(entero>19 && entero<41){
                    dato4 = dato + "," + dato1 + "," + dato2 + "," + dato3
                    intent.putExtra("DATO2", dato4)
                    startActivity(intent)
                }else{
                    alert.setText("El peso debe ser de 20 a 40 kilogramos")
                } }else{
                       alert.setText("Agrega un numero ")
                    }
                }
            }


        }
    }
}
