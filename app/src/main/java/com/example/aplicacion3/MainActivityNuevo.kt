package com.example.aplicacion3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacion3.databinding.ActivityMainNuevoBinding
import kotlinx.android.synthetic.main.activity_main_nuevo.*

class MainActivityNuevo : AppCompatActivity(){
        //vincular las vistas con MainActivity
  private lateinit var binding: ActivityMainNuevoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parExtra = intent.extras
        /*var miVar = parExtra?.getString("valor1")
        binding.txtDato.text =miVar.toString()*/

     binding.txtGuardar.setOnClickListener{
         val txtNom = binding.txtNombre.text
         val txtCue = binding.txtCuenta.text
         val txtCorr = binding.txtCorreo.text
         val txtImg = binding.txtImagen.text

         val intento2 = Intent (this, MainActivity::class.java)
         intento2.putExtra("mensaje", "nuevo")
         intento2.putExtra("nombre", "${txtNombre}")
         intento2.putExtra("cuenta", "${txtCuenta}")
         intento2.putExtra("correo", "${txtCorreo}")
         intento2.putExtra("imagen", "${txtImagen}")
         startActivity(intento2)
     }

    }
}