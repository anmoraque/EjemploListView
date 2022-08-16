package com.anmoraque.ejemplolistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
/*
En esta actividad hemos hablado de:
ListView con Adaptador personalizado (template)
Listener del lista en el ListView
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Creamos una variable ArrayList que contiene String
        var frutas:ArrayList<Fruta> = ArrayList()
        //Agrego frutas a la lista
        frutas.add(Fruta("Manzana", R.drawable.manzana))
        frutas.add(Fruta("Durazno", R.drawable.durazno))
        frutas.add(Fruta("Platano", R.drawable.platano))
        frutas.add(Fruta("Sandia", R.drawable.sandia))

        //Inicializamas la lista del Layout
        val lista = findViewById<ListView>(R.id.lista)

        //Creo un adaptador que se encarga de llevar mi lista al adapter
        //Nos pide el contexto (this) y por ultimo los elementos para hacer el mapeo (lista frutas)
        val adaptador = Adaptador(this, frutas)
        //Por ultimo lo linkeamos a la lista
        lista.adapter = adaptador

        //Ahora configuramos el listener de cada elemento de la lista
        //Usamos una funcion lambda
        lista.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            //Creamos un toas para ver el elemento pulsado cogiendo la posicion de este en la lista
            Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_LONG).show()
        }
    }
}