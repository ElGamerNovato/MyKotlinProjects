package com.example.appcomidas

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //Declare variables
    private lateinit var Producto:Spinner
    private lateinit var Cantidad:EditText
    private lateinit var Precio:TextView
    private lateinit var Total:TextView
    private lateinit var Delivery:CheckBox
    private lateinit var Descuento:TextView
    private lateinit var TotalPagar:TextView
    private lateinit var Calcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Producto=findViewById(R.id.spnProducto)
        Cantidad=findViewById(R.id.edtCantidad)
        Precio=findViewById(R.id.tvPrecio)
        Total=findViewById(R.id.tvTotal)
        Delivery=findViewById(R.id.chkDelivery)
        Descuento=findViewById(R.id.tvDescuento)
        TotalPagar=findViewById(R.id.tvTotalPagar)
        Calcular=findViewById(R.id.btnCalcular)

        //Asignamos evento a nuestro botón
        Calcular.setOnClickListener{calcular()}

    }

    fun calcular(){
        var posicionProducto:Int
        var cantidad:Int;
        var precio:Double
        var total:Double
        var delivery:Int
        var descuento:Double
        var totalPagar:Double
        //referenciar
        posicionProducto=Producto.selectedItemPosition
        cantidad=Cantidad.text.toString().toInt()
        //Procesos
        when(posicionProducto){
            0->precio=0.0
            1->precio=65.50
            2->precio=34.50
            3->precio=18.50
            4->precio=17.50
            5->precio=21.50
            //Esto solo está colocado como demostración
            else->{
                precio=21.5
            }
        }
        total=precio*cantidad

        //Verificar Delivery
        if(Delivery.isChecked)
            delivery=10
        else
            delivery=0

        //Verificar Descuento
        if(total>60)
            descuento=5.0
        else
            descuento=0.0

        //Calcular pago final
        totalPagar=(total+delivery)-descuento

        //Colocar las variables en la interfaz
        Precio.setText("S/. "+precio)
        Total.setText("S/. "+total)
        Descuento.setText("S/. "+descuento)
        TotalPagar.setText("S/. "+totalPagar)
    }

}