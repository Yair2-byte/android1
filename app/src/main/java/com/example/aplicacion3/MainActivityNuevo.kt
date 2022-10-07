package com.example.aplicacion3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacion3.databinding.ActivityMainNuevoBinding

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
    }
}