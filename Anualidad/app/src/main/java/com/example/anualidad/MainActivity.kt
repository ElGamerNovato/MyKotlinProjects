package com.example.anualidad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var cuotaMensual:EditText
    private lateinit var tasaAnual:EditText
    private lateinit var tiempo:EditText
    private lateinit var textoPrecioActual:TextView
    private lateinit var calcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cuotaMensual=findViewById(R.id.campoCuotaMensual)
        tasaAnual=findViewById(R.id.campoTasaAnual)
        tiempo=findViewById(R.id.campoTiempo)
        textoPrecioActual=findViewById(R.id.textoPrecioActual)
        calcular=findViewById(R.id.botonCalcular)
        calcular.setOnClickListener{funcionCalcular()}
    }

    fun funcionCalcular(){
        var CuotaMensual:Double
        var TasaAnual:Double
        var Tiempo:Int
        var PrecioActual:Double
        var TasaMensual:Double

        CuotaMensual=cuotaMensual.text.toString().toDouble()
        TasaAnual=tasaAnual.text.toString().toDouble()
        Tiempo=tiempo.text.toString().toInt()

        TasaMensual=(1+(TasaAnual/100)).pow(0.08333333333333)-1

        PrecioActual=((1-((1+TasaMensual).pow(-Tiempo)))/TasaMensual)*CuotaMensual

        textoPrecioActual.setText("Precio Actual: S/. "+PrecioActual)

    }

}