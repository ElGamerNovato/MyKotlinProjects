package com.example.appcine

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var cliente:EditText
    private lateinit var comedias:RadioButton
    private lateinit var dramaticas:RadioButton
    private lateinit var adultos:EditText
    private lateinit var ninos:EditText
    private lateinit var pelicula:Spinner

    var genero=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        cliente=findViewById(R.id.edtCliente)
        comedias=findViewById(R.id.rbComedias)
        dramaticas=findViewById(R.id.rbDramaticas)
        adultos=findViewById(R.id.edtAdultos)
        ninos=findViewById(R.id.edtNinos)
        pelicula=findViewById(R.id.spnPelicula)
        comedias.setOnClickListener{comedias()}
        dramaticas.setOnClickListener{dramaticas()}
    }

    fun comedias()
    {
        var peliculas= arrayListOf("Super cool", "¿Qué pasó ayer?")
        var data=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peliculas)
        pelicula.adapter=data
    }

    fun dramaticas()
    {
        var peliculas= arrayListOf("Lo imposible", "12 años de esclavitud", "Hitorias cruzadas")
        var data = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,peliculas)
        pelicula.adapter=data
    }

    fun procesar()
    {
        if(comedias.isChecked)
        {
            genero=0
        }
        else if(dramaticas.isChecked)
        {
            genero=1
        }
        var posicionPeli=pelicula.selectedItemPosition
        var costo=0.0
        when(genero)
        {
            0->
                when(posicionPeli)
                {
                    0->
                        costo=(adultos.text)*35.5+(ninos.text)*25.5
                }
        }
        var chaski=Intent(this, ProcesarActivity::class.java)
        chaski.putExtra("cliente", cliente.text.toString())
        chaski.putExtra("adultos", adultos.text)
        chaski.putExtra("ninos", ninos.text)
        chaski.putExtra("pelicula", pelicula.selectedItem.toString())
        chaski.putExtra("genero", genero)
        startActivity(chaski)
    }
}