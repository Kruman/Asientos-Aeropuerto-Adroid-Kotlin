package com.example.aeropuerto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner

class Pais : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pais)

        val dato = intent.getStringExtra("DATO2")
        var registro = ""
        if (dato != null) {
            registro = dato
        }
        val array = registro.split(",").toTypedArray()


        val continente = array[0]//continente a donde se quiere viajar
        var lista= listOf("") //iniciamos lista para los paises de cada continente

        var boton=findViewById<Button>(R.id.buttonEnviarPais) //boton para continuar

        val spinner: Spinner = findViewById(R.id.spinner2) //spinner para elejir pais

        //condicion when para escoger la lista de paises
        when(continente){
            "América"-> lista = listOf("Mexico", "Ecuador", "Brasil")
            "Asia"-> lista = listOf("China", "Hong kong", "Tokio")
            "Europa"-> lista = listOf("Barcelona","Berlin","Kiev")
            "África"-> lista = listOf("Sudafica","Egipto","Argelia")
            "Oceanía"-> lista = listOf("Australia")
        }

        //adaptador para el spinner
        val adaptador1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador1

        //iniciamos las variales de cada imagen
        val america = findViewById<ImageView>(R.id.americas)
        val asia = findViewById<ImageView>(R.id.asia)
        val africa = findViewById<ImageView>(R.id.africa)
        val europa = findViewById<ImageView>(R.id.europa)
        val oceania = findViewById<ImageView>(R.id.oceania)

        //hacemos invisiles todas las imagenes para que no se amontonen
        america.setVisibility(View.INVISIBLE)
        asia.setVisibility(View.INVISIBLE)
        europa.setVisibility(View.INVISIBLE)
        africa.setVisibility(View.INVISIBLE)
        oceania.setVisibility(View.INVISIBLE)

        //dependiendo de que continente se escogio es la imagen que se hara visile
        when (continente) {
            "América" -> america.setVisibility(View.VISIBLE)
            "Asia" -> asia.setVisibility(View.VISIBLE)
            "Europa" -> europa.setVisibility(View.VISIBLE)
            "África" -> africa.setVisibility(View.VISIBLE)
            "Oceanía" -> oceania.setVisibility(View.VISIBLE)
        }


        //evento con el boton en donde se obtiene el dato del spinner y se camia al otro activity
        boton.setOnClickListener {
            val spinner = findViewById<Spinner>(R.id.spinner2)
            val dato1 = spinner.getItemAtPosition(spinner.selectedItemPosition) as String
            val intent = Intent(this@Pais, Avion::class.java)
            val dato2 = dato+","+dato1
            intent.putExtra("DATO3", dato2)
            startActivity(intent)
        }

    }
}