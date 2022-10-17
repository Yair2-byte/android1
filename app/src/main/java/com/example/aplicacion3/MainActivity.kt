package com.example.aplicacion3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacion3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition
// esta es una actualizacion
class MainActivity : AppCompatActivity(){
    // ArrayList of class ItemsViewModel
        val data = ArrayList<Alumno>()

    // This will pass the ArrayList to our Adapter
    val adapter = AlumnoAdapter(this,data)


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


        // agregar elementos para la lista
            data.add(Alumno("Brandon Chacon", "201784568","cbhdm@bc.com","https://images4.alphacoders.com/101/1019228.jpg"))
            data.add(Alumno("Mario Beltran", "201884568","gddc@bc.com","https://images4.alphacoders.com/674/674016.png"))
            data.add(Alumno("Juan Escabeño", "201245542","dagc@bc.com","https://images5.alphacoders.com/795/795128.jpg"))
            data.add(Alumno("Bartolomeo Corazon", "20154812","sfrv@bc.com","https://images.alphacoders.com/883/883727.jpg"))
            data.add(Alumno("Luz Nevares", "201547920","dcarg@bc.com","https://images6.alphacoders.com/883/883730.jpg"))
            data.add(Alumno("Maria Pedregal", "201561982","dwtfs@bc.com","https://images.alphacoders.com/110/1109794.png"))

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : AlumnoAdapter.ClickListener{
            override fun onItemClick(view: View, position: Int) {
               //Toast.makeText(this@MainActivity,"Click en el item: ${position}", Toast.LENGTH_LONG).show()
                 itemOptionsMenu(position)
            }
        })

        //variable para recibir extras
        val parExtra = intent.extras
        val msje = parExtra?.getString("mensaje")
        val nombre = parExtra?.getString("nombre")
        val cuenta = parExtra?.getString("cuenta")
        val correo = parExtra?.getString("correo")
        val imagen = parExtra?.getString("imagen")
        if(msje == "nuevo"){
            val insertIndex: Int = data.count()
            data.add(insertIndex,
                Alumno(
                    "${nombre}",
                    "${cuenta}",
                    "${correo}",
                    "${imagen}"
                )
            )
            adapter.notifyItemInserted(insertIndex)
        }


        //click en el faButton
        binding.faButton.setOnClickListener{
          val intento1 = Intent (this, MainActivityNuevo::class.java)
            //intento1.putExtra("valor1")
            startActivity(intento1)
        }


    }

    private fun itemOptionsMenu(position: Int) {
        val popupMenu = PopupMenu(this,binding.recyclerview[position].findViewById(R.id.textViewOptions))
        popupMenu.inflate(R.menu.option_menu)
//Para cambiarnos de activity
        val intento2 = Intent(this,MainActivityNuevo::class.java)
//Implementar el click en el item
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.borrar -> {
                        val tmpAlum = data[position]
                        data.remove(tmpAlum)
                        adapter.notifyDataSetChanged()
                        return true
                    }
                    R.id.editar ->{
                        //Tomamos los datos del alumno, en la posición de la lista donde hicieron click
                        val nombre = data[position].nombre
                        val cuenta = data[position].cuenta
                        val correo = data[position].correo
                        val image = data[position].imagen
                        //En position tengo el indice del elemento en la lista
                        val idAlum: Int = position
                        intento2.putExtra("mensaje","edit")
                        intento2.putExtra("nombre","${nombre}")
                        intento2.putExtra("cuenta","${cuenta}")
                        intento2.putExtra("correo","${correo}")
                        intento2.putExtra("image","${image}")
                        //Pasamos por extras el idAlum para poder saber cual editar de la lista (ArrayList)
                        intento2.putExtra("idA",idAlum)
                        startActivity(intento2)
                        return true
                    }
                }
                return false
            }
        })
        popupMenu.show()
    }


}