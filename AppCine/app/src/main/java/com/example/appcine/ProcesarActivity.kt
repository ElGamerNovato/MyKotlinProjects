package com.example.appcine

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProcesarActivity : AppCompatActivity(){
    private lateinit var cliente:TextView
    private lateinit var genero:TextView
    private lateinit var pelicula:TextView
    private lateinit var adultos:TextView
    private lateinit var ninos:TextView
    private lateinit var imagen:ImageView
    private lateinit var montoAdulto:TextView
    private lateinit var montoNino:TextView
    private lateinit var total:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_procesar)
        cliente=findViewById(R.id.tvCliente)
        genero=findViewById(R.id.tvGenero)
        pelicula=findViewById(R.id.tvPelicula)
        adultos=findViewById(R.id.tvAdultos)
        ninos=findViewById(R.id.tvNinos)
        imagen=findViewById(R.id.imgPelicula)
        montoAdulto=findViewById(R.id.tvMontoAdulto)
        montoNino=findViewById(R.id.tvMontoNino)
        total=findViewById(R.id.tvTotal)
    }

    fun mostrar()
    {
        var info=intent.extras!!
        var cantidadAdultos=info.getInt("adultos")
        var cantidadNinos=info.getInt("ninos")
        cliente.setText("Cliente: "+info.getString("cliente"))
        genero.setText("Género: "+info.getString("genero"))
        pelicula.setText("Película: "+info.getString("pelicula"))
        adultos.setText("Cantidad de asientos adultos: "+info.getString("adultos"))
        ninos.setText("Cantidad de asientos niños: "+info.getString("ninos"))

    }

}