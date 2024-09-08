package com.example.pensioneskvbe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var alumno:EditText
    private lateinit var escuela:Spinner
    private lateinit var carrera:Spinner
    private lateinit var gastosBilioteca:CheckBox
    private lateinit var gastosMedio:CheckBox
    private lateinit var cuota4:RadioButton
    private lateinit var cuota5:RadioButton
    private lateinit var cuota6:RadioButton
    private lateinit var tvCostoCarrera:TextView
    private lateinit var tvPension:TextView
    private lateinit var tvGastos:TextView
    private lateinit var tvTotal:TextView
    private lateinit var botonCalcular:Button
    private lateinit var botonImprimir:Button
    //Globales
    var numeroCuotas=""
    var nombreEscuela=""
    var nombreCarrera=""
    var nombreGastos=""
    var montoGastos=0
    fun calcular(){
        var posicionEscuela:Int
        var posicionCarrera:Int
        var costocarrera:Double = 1.0
        var costoFinal:Double
        var pension:Double
        var cuotas:Int=1
        var porcentaje:Double = 0.0
        var gastosAdicionales:Int=0
        posicionEscuela=escuela.selectedItemPosition
        posicionCarrera=carrera.selectedItemPosition
        when(posicionEscuela){
            0->
                when(posicionCarrera){
                    0-> costocarrera=3200.0
                    1-> costocarrera=3100.0
                    2-> costocarrera=3000.0
                    3-> costocarrera=0.0
                }
            1->
                when(posicionCarrera){
                    0-> costocarrera=2800.0
                    1-> costocarrera=2700.0
                    2-> costocarrera=2600.0
                    3-> costocarrera=2650.0
                    4-> costocarrera=2750.0
                    5-> costocarrera=2550.0
                    6-> costocarrera=0.0
                    7-> costocarrera=0.0
                }
        }
        nombreEscuela=escuesla.selectedItem.toString()
        nombreCarrera=carrera.selectedItem.toString()
        if(cuota4.isChecked){
            numeroCuotas=cuota4.text.toString()
            porcentaje=0.0
            cuotas=4
        }
        else if(cuota5.isChecked){
            numeroCuotas=cuota5.text.toString()
            porcentaje=12.0
            cuotas=5
        }
        else if(cuota6.isChecked){
            numeroCuotas=cuota6.text.toString()
            porcentaje=16.0
            cuotas=6
        }
        //Operaciones
        pension=(costocarrera+(costocarrera*porcentaje/100))/cuotas
        //Calcular gastos adicionales
        if(gastosBilioteca.isChecked){
            gastosAdicionales+=25
            nombreGastos+="Carnet de Biblioteca "
        }
        if(gastosMedio.isChecked){
            gastosAdicionales+=22
            nombreGastos+="Carnet de Medio Pasaje"
        }
        costoFinal=(costocarrera+(costocarrera*porcentaje/100))+gastosAdicionales
        montoGastos=gastosAdicionales
        tvCostoCarrera.setText("S/. "+costocarrera)
        tvPension.setText("S/. "+pension)
        tvGastos.setText("S/. "+gastosAdicionales)
        tvTotal.setText("S/. "+costoFinal)
    }
    fun imprimir(){
        var chaski=Intent(this, ImprimirActivity::class.java)
        chaski.putExtra("alumno", alumno.text.toString())
        chaski.putExtra("escuela", nombreEscuela)
        chaski.putExtra("carrera", nombreCarrera)
        chaski.putExtra("gastosAdicionales", nombreGastos)
        chaski.putExtra("montoGastosAdicionales", montoGastos.toString())
        chaski.putExtra("numeroCuotas", numeroCuotas)
        chaski.putExtra("costoCarrera", tvCostoCarrera.text.toString())
        chaski.putExtra("pension", tvPension.text.toString())
        chaski.putExtra("total", tvTotal.text.toString())
        startActivity(chaski)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        botonCalcular=findViewById(R.id.btnCalcular)
        botonImprimir=findViewById(R.id.btnImprimir)
        alumno=findViewById(R.id.edtAlumno)
        escuela=findViewById(R.id.spnEscuela)
        carrera=findViewById(R.id.spnCarrera)
        gastosBilioteca=findViewById(R.id.cbCarnetBiblioteca)
        gastosMedio=findViewById(R.id.cbCarnetMedioPasaje)
        cuota4=findViewById(R.id.rb4)
        cuota5=findViewById(R.id.rb5)
        cuota6=findViewById(R.id.rb6)
        tvCostoCarrera=findViewById(R.id.tvMontoCostoCarrera)
        tvPension=findViewById(R.id.tvMontoPension)
        tvGastos=findViewById(R.id.tvMontoGastosAdicionales)
        tvTotal=findViewById(R.id.tvMontoTotalPagar)
        botonCalcular.setOnClickListener{calcular()}
        botonImprimir.setOnClickListener{imprimir()}
        //Crear el adaptador para el array Escuela
        val adaptadorEscuela=ArrayAdapter(this, android.R.layout.simple_spinner_item, escuelas)
        adaptadorEscuela.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        escuela.adapter=adaptadorEscuela
        //Evento
        escuela.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Obtener la escuela seleccionada
                val escuelaSeleccionada = parent.getItemAtPosition(position).toString()

                // Obtener las carreras asociadas a la escuela seleccionada
                val carreras = carreras[escuelaSeleccionada]

                // Adaptador para el Spinner de Carreras
                if (carreras != null) {
                    val adapterCarrera = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, carreras)
                    adapterCarrera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    carrera.adapter = adapterCarrera
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No se hace nada si no se selecciona nada
            }
        }
    }
    val escuelas = arrayOf("Tecnologías de la información", "Gestión y negocios")
    val carreras = mapOf("Tecnologías de la información" to arrayOf("Computación e informática" ,
            "Administración de redes y comunicaciones" ,
            "Administración y sistemas" ,
            "Industrial y sistemas"),
            "Gestión y negocios" to arrayOf("Administración de empresas" ,
                    "Contabilidad" ,
                    "Marketing" ,
                    "Administración de negocios internacionales" ,
                    "Administración de negocios bancarios y financieros" ,
                    "Gestión de recursos humanos" ,
                    "Gestión de logística (nueva)" ,
                    "Administración de operaciones turísticas"))

}