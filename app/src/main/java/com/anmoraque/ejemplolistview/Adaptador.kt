package com.anmoraque.ejemplolistview

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Esta clase hereda de BaseAdapter y sirve para implementar nuestro layout template
//Recibe el contexto y un items que es una lista de frutas
//Tenemos que implementar los metodos exigidos
class Adaptador(var context: Context, items: ArrayList<Fruta>):BaseAdapter() {
    var items: ArrayList<Fruta>? = null
    init {
        this.items = items
    }

    override fun getCount(): Int {
        //Regresamos el contador del items seria opcional ? y para obtener el valor !!
        return items?.count()!!
    }

    override fun getItem(p0: Int): Any {
        //Regresamos la posicion de cada items seria opcional ? y para obtener el valor !!
        return items?.get(p0)!!
    }

    override fun getItemId(p0: Int): Long {
        //Regresamos la posicion (p0) larga
        return p0.toLong()
    }
    //Esta es la funcion mas importante, aqui se configura un objeto tipo vista donde se
    //inserta el layout template, se valida si tiene o no un valor
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //Creamos un objeto tipo ViewHolder
        var holder:ViewHolder? = null
        //Luego otro tipo vista de tipo convertView
        var vista:View? = p1
        //Ahora vamos a validarlo si la vista no tiene contenido alguno
        if (vista == null){
            //le inflamos el layout template a la variable vista
            vista = LayoutInflater.from(context).inflate(R.layout.template, null)
            //Seguido le decimos al holder que es un nuevo objeto viewHolder de la variable vista
            holder = ViewHolder(vista)
            //Y por ultimo añadimos una etiqueta (TAG) para identificarlo
            vista.tag = holder
        //Si la vista ya tiene algun contenido lo referenciamos
        }else{
            //El holder es igual al TAG vista y lo casteamos a un viewHolder
            holder = vista.tag as? ViewHolder
        }
        //Creamos un nuevo elemento item y lo obtenemos en la posicion que este renderizando
        //y lo transformamos a tipo fruta
        val item = getItem(p0) as Fruta
        //Ahora asignamos los valores de la fruta en el holder
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)
        //Regresamos la vista y le ponemos !! para obtener el valor
        return vista!!
    }
    //Esta clase hay que implementarla porque es un patron y nos permite declarar
    // nuestros objetos a traves de la interfaz grafica con (findbyid) solamente
    // una vez y no cada vez que se renderice la vista, recibe una vista
    private class ViewHolder (vista:View){
        var nombre:TextView? = null
        var imagen:ImageView? = null
        init {
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
        }

    }
}