package com.example.credito

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.pow
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var precio:EditText
    private lateinit var tasaAnual:EditText
    private lateinit var tiempo:EditText
    private lateinit var decimales:CheckBox
    private lateinit var calcular:Button
    private lateinit var tasaMensual:TextView
    private lateinit var cuotaMensual:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        precio=findViewById(R.id.casillaPrecio)
        tasaAnual=findViewById(R.id.casillaTasaAnual)
        tiempo=findViewById(R.id.casillaTiempo)
        decimales=findViewById(R.id.checkboxDecimales)
        calcular=findViewById(R.id.botonCalcular)
        tasaMensual=findViewById(R.id.textoTasaMensual)
        cuotaMensual=findViewById(R.id.textoCuotaMensual)
        calcular.setOnClickListener{funcionCalcular()}

    }

    fun funcionCalcular(){
        var Precio:Double
        var TasaAnual:Double
        var Tiempo:Int
        var TasaMensual:Double
        var CuotaMensual:Double

        Precio=precio.text.toString().toDouble()
        TasaAnual=tasaAnual.text.toString().toDouble()
        Tiempo=tiempo.text.toString().toInt()

        TasaMensual=(1+(TasaAnual/100)).pow(0.08333333333333)-1
        CuotaMensual=Precio*((TasaMensual*((1+TasaMensual).pow(Tiempo)))/(((1+TasaMensual).pow(Tiempo))-1))

        if(decimales.isChecked)
        else
            CuotaMensual=round(CuotaMensual)

        tasaMensual.setText("Tasa Mensual: S/. "+TasaMensual)
        cuotaMensual.setText("Cuota Mensual: S/. "+CuotaMensual)

    }
}