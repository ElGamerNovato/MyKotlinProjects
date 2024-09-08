package com.example.aplicacionservicios

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ImprimirActivity:AppCompatActivity(){
    private lateinit var tvCliente:TextView
    private lateinit var tvDNI:TextView
    private lateinit var tvServicio:TextView
    private lateinit var tvCostoServicio:TextView
    private lateinit var tvCostoInstalacion:TextView
    private lateinit var tvDescuento:TextView
    private lateinit var tvTotalPagar:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imprimir)
        tvCliente=findViewById(R.id.RCliente)
        tvDNI=findViewById(R.id.RDNI)
        tvServicio=findViewById(R.id.RServicio)
        tvCostoServicio=findViewById(R.id.RCostoServicio)
        tvCostoInstalacion=findViewById(R.id.RCostoInstalacion)
        tvDescuento=findViewById(R.id.RDescuento)
        tvTotalPagar=findViewById(R.id.RTotalPagar)
        datos()
        }
    fun datos()
    {
        //recuperar datos de la otra pantalla usando Intent. Colocamos !! para evitar colocarla a cada rato
        var info=intent.extras!!
        //mostrar la clave cliente
        tvCliente.setText("CLIENTE: "+info.getString("cliente"))
        tvDNI.setText("DNI: "+info.getString("dni"))
        tvServicio.setText("Servicio: "+info.getString("nombreServicio"))
        tvCostoServicio.setText("Costo del Servicio: "+info.getString("costoS"))
        tvCostoInstalacion.setText("Costo de la instalación: "+info.getString("costoI"))
        tvDescuento.setText("Descuento: "+info.getString("descuento"))
        tvTotalPagar.setText("Total a Pagar: "+info.getString("totalPagar"))
    }
    }