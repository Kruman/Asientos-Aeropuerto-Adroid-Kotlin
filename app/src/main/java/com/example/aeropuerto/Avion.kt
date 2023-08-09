package com.example.aeropuerto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton

class Avion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avion)

        val dato = intent.getStringExtra("DATO3")
        val enviar = findViewById<Button>(R.id.enviar)
        val A1 = findViewById<ImageButton>(R.id.A1)
        val A2 = findViewById<ImageButton>(R.id.A2)
        val A3 = findViewById<ImageButton>(R.id.A3)
        val A4 = findViewById<ImageButton>(R.id.A4)
        val A5 = findViewById<ImageButton>(R.id.A5)
        val A6 = findViewById<ImageButton>(R.id.A6)
        val B1 = findViewById<ImageButton>(R.id.B1)
        val B2 = findViewById<ImageButton>(R.id.B2)
        val B3 = findViewById<ImageButton>(R.id.B3)
        val B4 = findViewById<ImageButton>(R.id.B4)
        val B5 = findViewById<ImageButton>(R.id.B5)
        val B6 = findViewById<ImageButton>(R.id.B6)


        fun asientosOcupados(vuelo: String): List<String> {
            val dbHandler = AdminSQLiteOpenHelper(this, "aeropuerto", null, 1)
            val db = dbHandler.readableDatabase
            val asientos = mutableListOf<String>()

            val query = "SELECT asiento FROM vuelos WHERE vuelo = ?"
            val selectionArgs = arrayOf(vuelo)
            val cursor = db.rawQuery(query, selectionArgs)
            if (cursor != null && cursor.moveToFirst()){
                val columnIndex = cursor.getColumnIndex("asiento")
                if (columnIndex > -1) {
                    do {
                        val asiento = cursor.getString(columnIndex)
                        asientos.add(asiento)
                    } while (cursor.moveToNext())
                }
                cursor.close()
            }

            db.close()


            return asientos
        }


        var registro = ""
        if (dato != null) {
            registro = dato
        }
        val array = registro.split(",").toTypedArray()
        val adul = array[2].toInt()
        val ni = array[3].toInt()
        val asient = asientosOcupados(array[1]+array[2])
        var num = adul+ni
        val flags = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        var newArray = arrayOf<String>()
        var selecion = arrayOf<String>()
        val Botones =mutableListOf<ImageButton>(A1,A2,A3,A4,A5,A6,B1,B2,B3,B4,B5,B6)

        for (g in asient) {
            Log.d(g, "AQUI")
            }
        for (elemento in asient) {
            when (elemento) {
                "A1"-> {A1.isEnabled = false
                    A1.setImageResource(R.drawable.rrojo)}
                "A2"-> {A2.isEnabled = false
                    A2.setImageResource(R.drawable.rrojo)}
                "A3"-> {A3.isEnabled = false
                    A3.setImageResource(R.drawable.rrojo)}
                "A4"-> {A4.isEnabled = false
                    A4.setImageResource(R.drawable.rrojo)}
                "A5"-> {A5.isEnabled = false
                    A5.setImageResource(R.drawable.rrojo)}
                "A6"-> {A6.isEnabled = false
                    A6.setImageResource(R.drawable.rrojo)}
                "B1"-> {B1.isEnabled = false
                    B1.setImageResource(R.drawable.rrojo)}
                "B2"-> {B2.isEnabled = false
                    B2.setImageResource(R.drawable.rrojo)}
                "B3"-> {B3.isEnabled = false
                    B3.setImageResource(R.drawable.rrojo)}
                "B4"-> {B4.isEnabled = false
                    B4.setImageResource(R.drawable.rrojo)}
                "B5"-> {B5.isEnabled = false
                    B5.setImageResource(R.drawable.rrojo)}
                "B6"-> {B6.isEnabled = false
                    B6.setImageResource(R.drawable.rrojo)}
            }
        }


        A1.setOnClickListener {
            if(num>0 && flags[0]==0){
                A1.setImageResource(R.drawable.check)
                flags[0]=1
                selecion=selecion.plus("A1")
                num=num-1}
                else if(flags[0]==1){
                A1.setImageResource(R.drawable.nada)
                flags[0]=0
                num=num+1
                val index = array.indexOf("A1")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}
                } }

        A2.setOnClickListener {
            if(num>0 && flags[1]==0){
                A2.setImageResource(R.drawable.check)
                flags[1]=1
                selecion=selecion.plus("A2")
                num=num-1}
                else if(flags[1]==1){
                    A2.setImageResource(R.drawable.nada)
                    flags[1]=0
                    num=num+1
                val index = array.indexOf("A2")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        A3.setOnClickListener {
            if(num>0 && flags[2]==0) {
                A3.setImageResource(R.drawable.check)
                flags[2]=1
                selecion=selecion.plus("A3")
                num=num-1}
                else if(flags[2]==1){
                    A3.setImageResource(R.drawable.nada)
                    flags[2]=0
                    num=num+1
                val index = array.indexOf("A3")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        A4.setOnClickListener {
            if(num>0 && flags[3]==0) {
                A4.setImageResource(R.drawable.check)
                flags[3]=1
                selecion=selecion.plus("A4")
                num=num-1}
                else if(flags[3]==1){
                    A4.setImageResource(R.drawable.nada)
                    flags[3]=0
                    num=num+1
                val index = array.indexOf("A4")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        A5.setOnClickListener {
            if(num>0 && flags[4]==0) {
                A5.setImageResource(R.drawable.check)
                flags[4]=1
                selecion=selecion.plus("A5")
                num=num-1}
                else if(flags[4]==1){
                    A5.setImageResource(R.drawable.nada)
                    flags[4]=0
                    num=num+1
                val index = array.indexOf("A5")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        A6.setOnClickListener {
            if(num>0 && flags[5]==0) {
                A6.setImageResource(R.drawable.check)
                flags[5]=1
                selecion=selecion.plus("A6")
                num=num-1}
                else if(flags[5]==1){
                    A6.setImageResource(R.drawable.nada)
                    flags[5]=0
                    num=num+1
                val index = array.indexOf("A6")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        B1.setOnClickListener {
            if(num>0 && flags[6]==0) {
                B1.setImageResource(R.drawable.check)
                flags[6]=1
                selecion=selecion.plus("B1")
                num=num-1}
                else if(flags[6]==1){
                    B1.setImageResource(R.drawable.nada)
                    flags[6]=0
                    num=num+1
                val index = array.indexOf("B1")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        B2.setOnClickListener {
            if(num>0 && flags[7]==0) {
                B2.setImageResource(R.drawable.check)
                flags[7]=1
                selecion=selecion.plus("B2")
                num=num-1}
                else if(flags[7]==1){
                    B2.setImageResource(R.drawable.nada)
                    flags[7]=0
                    num=num+1
                val index = array.indexOf("B2")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        B3.setOnClickListener {
            if(num>0 && flags[8]==0) {
                B3.setImageResource(R.drawable.check)
                flags[8]=1
                selecion=selecion.plus("B3")
                num=num-1}
                else if(flags[8]==1){
                    B3.setImageResource(R.drawable.nada)
                    flags[8]=0
                    num=num+1
                val index = array.indexOf("B3")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        B4.setOnClickListener {
            if(num>0 && flags[9]==0) {
                B4.setImageResource(R.drawable.check)
                flags[9]=1
                selecion=selecion.plus("B4")
                num=num-1}
                else if(flags[9]==1){
                    B4.setImageResource(R.drawable.nada)
                    flags[9]=0
                    num=num+1
                val index = array.indexOf("AB")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        B5.setOnClickListener {
            if(num>0 && flags[10]==0) {
                B5.setImageResource(R.drawable.check)
                flags[10]=1
                selecion=selecion.plus("B5")
                num=num-1}
                else if(flags[10]==1){
                    B5.setImageResource(R.drawable.nada)
                    flags[10]=0
                    num=num+1
                val index = array.indexOf("B5")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }

        B6.setOnClickListener {
            if(num>0 && flags[11]==0) {
                B6.setImageResource(R.drawable.check)
                flags[11]=1
                selecion=selecion.plus("B6")
                num=num-1}
                else if(flags[11]==1){
                    B6.setImageResource(R.drawable.nada)
                    flags[11]=0
                    num=num+1
                val index = array.indexOf("B6")
                if (index >= 0) {
                    newArray = array.copyOfRange(0, index) + array.copyOfRange(index + 1, array.size)
                    selecion = newArray}} }


        enviar.setOnClickListener {
            val intent = Intent(this, Resumen::class.java)
            val cadena = selecion.joinToString(separator = "-")

            intent.putExtra("Selecion",cadena)
            intent.putExtra("DATO4", dato)
            startActivity(intent)
        }



    }
}

