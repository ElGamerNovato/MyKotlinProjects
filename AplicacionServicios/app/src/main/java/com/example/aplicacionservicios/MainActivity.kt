package com.example.aplicacionservicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var btnImprimir:Button
    private lateinit var btnCalcular:Button
    private lateinit var Cliente:TextView
    private lateinit var DNI:TextView
    private lateinit var rbtnDuo:RadioButton
    private lateinit var rbtnTrio:RadioButton
    private lateinit var rbtnCamaras:RadioButton
    private lateinit var rbtnARobos:RadioButton
    private lateinit var rbtnAIncendio:RadioButton
    private lateinit var rbtnCercos:RadioButton
    private lateinit var CostoServicio:TextView
    private lateinit var CostoInstalacion:TextView
    private lateinit var Descuento:TextView
    private lateinit var Total:TextView
    //variables globales
    var costoServicio:Double=0.0;var costoInstalacion:Double=0.0;var descuento:Double=0.0;var total:Double=0.0
    var nombreServicio=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Referenciar
        btnImprimir=findViewById(R.id.btnImprimir)
        btnCalcular=findViewById(R.id.btnCalcular)
        DNI=findViewById(R.id.edtDNI)
        rbtnDuo=findViewById(R.id.rbtnDuo)
        rbtnTrio=findViewById(R.id.rbtnTrio)
        rbtnCamaras=findViewById(R.id.rbtonCamaras)
        rbtnARobos=findViewById(R.id.rbtnARobos)
        rbtnAIncendio=findViewById(R.id.rbtnAIncendio)
        rbtnCercos=findViewById(R.id.rbtnCercos)
        CostoServicio=findViewById(R.id.tvCostoServicio)
        CostoInstalacion=findViewById(R.id.tvCostoInstalacion)
        Descuento=findViewById(R.id.tvDescuento)
        Total=findViewById(R.id.tvTotalPagar)
        //Asignar Evento
        btnImprimir.setOnClickListener{imprimir()}
        btnCalcular.setOnClickListener{calcular()}
        Cliente=findViewById(R.id.edtCliente)
    }
    fun imprimir(){
        var cliente:String
        cliente=Cliente.text.toString()
        //Crear objeto de clase Intent
        var chaski= Intent(this, ImprimirActivity::class.java)
        //Asignar claves a Intent
        chaski.putExtra("cliente",cliente)
        chaski.putExtra("dni",DNI.text.toString())
        chaski.putExtra("nombreServicio",nombreServicio)
        chaski.putExtra("costoS",CostoServicio.text.toString())
        chaski.putExtra("costoI",CostoInstalacion.text.toString())
        chaski.putExtra("descuento", Descuento.text.toString())
        chaski.putExtra("totalPagar",Total.text.toString())
        //Direccionar
        startActivity(chaski)
    }
    fun calcular()
    {
        if(rbtnDuo.isChecked){
            nombreServicio=rbtnDuo.text.toString()
            descuento=7.00
            costoServicio=119.30
            costoInstalacion=37.00
        }
        else if(rbtnTrio.isChecked) {
            nombreServicio = rbtnTrio.text.toString()
            descuento=12.00
            costoServicio = 169.8
            costoInstalacion = 65.00
        }
        else if(rbtnCamaras.isChecked) {
            nombreServicio = rbtnCamaras.text.toString()
            descuento=4.00
            costoServicio = 59.50
            costoInstalacion = 21.00
        }
        else if(rbtnARobos.isChecked) {
            nombreServicio = rbtnARobos.text.toString()
            descuento=4.00
            costoServicio = 49.20
            costoInstalacion = 17.00
        }
        else if(rbtnAIncendio.isChecked) {
            nombreServicio = rbtnAIncendio.text.toString()
            descuento=4.00
            costoServicio = 42.30
            costoInstalacion = 15.00
        }
        else
            nombreServicio = rbtnCercos.text.toString()
            descuento=5.00
            costoServicio = 125.70
            costoInstalacion = 35.00

        descuento=costoServicio*(descuento/100)
        total=(costoInstalacion+costoServicio)-descuento
        CostoServicio.setText("S/. "+costoServicio)
        CostoInstalacion.setText("S/. "+costoInstalacion)
        Descuento.setText("S/. "+descuento)
        Total.setText("S/. "+total)
    }
}