package com.example.aplicacion3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacion3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
//vincular las vistas con MainActivity
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Alumno>()

        // agregar elementos para la lista
            data.add(Alumno("Brandon Chacon", "201784568","cbhdm@bc.com","https://images4.alphacoders.com/101/1019228.jpg"))
            data.add(Alumno("Mario Beltran", "201884568","gddc@bc.com","https://images4.alphacoders.com/674/674016.png"))
            data.add(Alumno("Juan Escabeño", "201245542","dagc@bc.com","https://images5.alphacoders.com/795/795128.jpg"))
            data.add(Alumno("Bartolomeo Corazon", "20154812","sfrv@bc.com","https://images.alphacoders.com/883/883727.jpg"))
            data.add(Alumno("Luz Nevares", "201547920","dcarg@bc.com","https://images6.alphacoders.com/883/883730.jpg"))
            data.add(Alumno("Maria Pedregal", "201561982","dwtfs@bc.com","https://images.alphacoders.com/110/1109794.png"))


        // This will pass the ArrayList to our Adapter
        val adapter = AlumnoAdapter(this,data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        //click en agregar
        faButton.setOnClickListener{
            val intento1 = Intent(this, MainActivityNuevo::class.java)
            //intento1.putExtra("valor1", "hola mundo");
            startActivity(intento1)
        }
    }

}