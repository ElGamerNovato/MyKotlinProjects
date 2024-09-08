package com.example.pensioneskvbe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ImprimirActivity : AppCompatActivity(){
    private lateinit var alumno:TextView
    private lateinit var escuela:TextView
    private lateinit var carrera:TextView
    private lateinit var gastosAdicionales:TextView
    private lateinit var montoGastosAdicionales:TextView
    private lateinit var numeroCuotas:TextView
    private lateinit var costoCarrera:TextView
    private lateinit var pension:TextView
    private lateinit var totalPagar:TextView
    private lateinit var botonVolver:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imprimir)
        alumno=findViewById(R.id.Alumno)
        escuela=findViewById(R.id.Escuela)
        carrera=findViewById(R.id.Carrera)
        gastosAdicionales=findViewById(R.id.GastosAdicionales)
        montoGastosAdicionales=findViewById(R.id.MontoGastosAdicionales)
        numeroCuotas=findViewById(R.id.NumeroCuotas)
        costoCarrera=findViewById(R.id.CostoCarrera)
        pension=findViewById(R.id.Pension)
        totalPagar=findViewById(R.id.TotalPagar)
        botonVolver=findViewById(R.id.btnVolver)
        datos()
    }
    fun datos(){
        var info=intent.extras!!
        alumno.setText("Alumno: "+info.getString("alumno"))
        escuela.setText("Escuela: "+info.getString("escuela"))
        carrera.setText("Carrera: "+info.getString("carrera"))
        gastosAdicionales.setText("Gastos adicionales: S/. "+info.getString("gastosAdicionales"))
        montoGastosAdicionales.setText("Monto de los gastos adicionales: S/. "+info.getString("montoGastosAdicionales"))
        numeroCuotas.setText("Número de Cuotas: "+info.getString("numeroCuotas"))
        costoCarrera.setText("Costo de la carrera: S/. "+info.getString("costoCarrera"))
        pension.setText("Pensión: S/. "+info.getString("pension"))
        totalPagar.setText("Total a pagar: S/. "+info.getString("total"))
    }
}