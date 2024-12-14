package com.example.practica06

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleConciertoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_concierto)

        val concierto = intent.getSerializableExtra("concierto") as? Concierto

        val tvDetalles = findViewById<TextView>(R.id.txtDatos)

        concierto?.let {
            var servicio: String? = null
            if(it.servicio == 1) servicio = "Económico"
            if(it.servicio == 2) servicio = "General"
            if(it.servicio == 3) servicio = "Exclusivo"

            tvDetalles.text = "Código del boleto: ${it.codigo}\n" +
                    "Artista: ${it.artista}\n" +
                    "Lugar: ${it.lugar}\n" +
                    "Fecha (DD/MM/AA): ${it.fecha}\n" +
                    "Tipo de servicio: ${servicio}\n" +
                    "Zona: ${it.zona}\n"
        }

        val ibtnRegresar = findViewById<ImageButton>(R.id.ibtnRegresar)
        ibtnRegresar.setOnClickListener {
            finish()
        }
    }

}