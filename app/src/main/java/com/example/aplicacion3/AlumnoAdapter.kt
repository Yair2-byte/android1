package com.example.aplicacion3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnoAdapter (private val context: Context, val listAlumno: List <Alumno>) : RecyclerView.Adapter<AlumnoAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imagenAlumno: ImageView = itemView.findViewById(R.id.imgAlumno)
        val txtNombre: TextView = itemView.findViewById(R.id.nombre)
        val txtCuenta: TextView = itemView.findViewById(R.id.cuenta)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = listAlumno[position]

        // sets the image to the imageview from our itemHolder class
        Glide.with(context).load(ItemsViewModel.imagen).into(holder.imagenAlumno)
        // sets the text to the textview from our itemHolder class
        holder.txtNombre.text = ItemsViewModel.nombre
        holder.txtCuenta.text = ItemsViewModel.cuenta
    }

    override fun getItemCount(): Int {
        return listAlumno.size
    }
}