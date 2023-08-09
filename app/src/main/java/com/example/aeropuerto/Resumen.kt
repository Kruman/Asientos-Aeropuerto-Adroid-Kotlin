package com.example.aeropuerto

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Resumen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val button=findViewById<Button>(R.id.cerrar) //oton para cerrar app
        val asientos = intent.getStringExtra("Selecion")
        val dato = intent.getStringExtra("DATO4")
        val destino = findViewById<TextView>(R.id.des)
        val adultos = findViewById<TextView>(R.id.ad)
        val niños = findViewById<TextView>(R.id.nin)
        val equipaje = findViewById<TextView>(R.id.eq)
        val aerolinea = findViewById<TextView>(R.id.ae)
        val total = findViewById<TextView>(R.id.tot)//variable donde se colocara el dato otenido
        var registro = ""
        var vla = 1
        var vlb = 1

      if (dato != null) {
            registro = dato
        }
        val array = registro.split(",").toTypedArray()

        when(array[5]){
            "China" ->{ vla = 10000
                vlb =5000}
                "Barcelona" ->{ vla = 15000
                    vlb =7000}
                "Hong kong" ->{ vla = 18000
                    vlb =8000}
                "Berlin" ->{ vla = 16000
                    vlb =7000}
                "Tokio" ->{ vla = 19000
                    vlb =9000}
                "Kiev" ->{ vla = 20000
                    vlb =10000}
                "Sudafrica" ->{ vla = 350000
                    vlb =25000}
                "Australia" ->{ vla = 40000
                    vlb =35000}
                "Egipto" ->{ vla = 25500
                    vlb =20500}
                "Argelia" ->{ vla = 23800
                    vlb =13800}
                "Mexico" ->{ vla = 19000
                    vlb =16000}
                "Ecuador" ->{ vla = 14000
                    vlb =10000}
                "Brasil" ->{ vla = 16000
                    vlb =11000}
            }

            var adul = array[2].toInt()
            var ni = array[3].toInt()
        var equi = array[4].toInt()
        var cste = equi * 20
            var total1 = adul * vla
            var total2 = ni * vlb
            var total3 = total1+total2+cste
        var fin = total3.toString()

        destino.setText(array[5])
        adultos.setText(array[2])
        niños.setText(array[3])
        equipaje.setText(array[4])
        aerolinea.setText(array[1])
        total.setText(fin)

        var reg=""
        if (asientos != null) {
            reg = asientos
        }
        val array2 = reg.split("-").toTypedArray()



        fun agregar(datos: Array<String>) {
            val dbHandler = AdminSQLiteOpenHelper(this, "aeropuerto", null, 1)
            val db = dbHandler.writableDatabase

            for (asiento in datos) {
                val values = ContentValues()
                values.put("vuelo", array[1]+array[2])
                values.put("asiento", asiento)

                db.insert("vuelos", null, values)
            }
            db.close()
        }

        button.setOnClickListener {
            agregar(array2)
            finishAffinity() //metodo para cerrar toda la App
        }
    }


}