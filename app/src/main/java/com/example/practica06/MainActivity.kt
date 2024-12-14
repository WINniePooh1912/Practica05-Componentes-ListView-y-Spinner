package com.example.practica06

import android.content.Intent
import android.widget.*
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    private var conciertos = arrayOfNulls<Concierto>(5) // Arreglo de 5 conciertos
    private var contador = 0

    private lateinit var edtCodigo: EditText
    private lateinit var edtLugar: EditText
    private lateinit var edtFecha: EditText

    private lateinit var lvZona: ListView
    private var zonaSel: String = "Palco Inferior Izquierdo"

    private lateinit var spArtista: Spinner
    private var artistaSel: String = "5 Seconds of Summer"

    private lateinit var chServicios: ChipGroup
    private lateinit var chSEcomomico: Chip
    private lateinit var chSGeneral: Chip
    private lateinit var chSExclusivo: Chip


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtCodigo = findViewById(R.id.edtCodigo)
        edtLugar = findViewById(R.id.edtLugar)
        edtFecha = findViewById(R.id.edtFecha)
        lvZona = findViewById(R.id.ltvZona)
        spArtista = findViewById(R.id.spnArtista)
        chServicios = findViewById(R.id.gpoChServicios)
        chSEcomomico = findViewById(R.id.chServEc)
        chSGeneral = findViewById(R.id.chServGen)
        chSExclusivo = findViewById(R.id.chServVIP)




        val lstArtista = resources.getStringArray(R.array.listaArtistas)
        val adapArtista = ArrayAdapter(this,
            R.layout.spinner_color_selected, lstArtista)
        adapArtista.setDropDownViewResource(R.layout.spinner_color_dropdown)
        spArtista.adapter = adapArtista
        spArtista.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2:
                    Int, p3: Long
                ) {
                    artistaSel = lstArtista[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    } //onCreate

    fun onClick(v: View?){
        when(v?.id){
            R.id.ibtnAgregar -> agregar()
            R.id.ibtnBuscar -> buscar()
            R.id.ibtnLimpiar -> limpiar()
            R.id.ibtnEliminar -> eliminar()
        }
    }

    private fun agregar() {
        if (contador < conciertos.size) {
            if(edtCodigo.text.isNotBlank() && edtCodigo.text.isNotEmpty()){
                val codigo = edtCodigo.text.toString().toInt()
                val artista = artistaSel
                val lugar = edtLugar.text.toString()
                val fecha = edtFecha.text.toString()
                val zona = zonaSel

                var servicio = 2
                if(chSEcomomico.isChecked) servicio = 1
                if(chSGeneral.isChecked) servicio = 2
                if(chSExclusivo.isChecked) servicio = 3

                conciertos[contador] = Concierto(codigo, artista, lugar, fecha, servicio, zona)
                contador++

                limpiar()
                Toast.makeText(this, "Concierto registrado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingresa el código del boleto", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No hay más espacio para conciertos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun buscar() {
        if(edtCodigo.text.isNotBlank() && edtCodigo.text.isNotEmpty()){
            val codigo = edtCodigo.text.toString().toInt()
            val conciertoEncontrado = conciertos.find { it?.codigo == codigo }

            if (conciertoEncontrado != null) {
                val intent = Intent(this, DetalleConciertoActivity::class.java)
                intent.putExtra("concierto", conciertoEncontrado)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Concierto no encontrado", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingresa el código del boleto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun limpiar() {
        edtCodigo.text = null
        edtLugar.text = null
        edtFecha.text = null
        chServicios.clearCheck()

        edtCodigo.requestFocus()
    }

    private fun eliminar() {
        if(edtCodigo.text.isNotBlank() && edtCodigo.text.isNotEmpty()){
            val codigo = edtCodigo.text.toString().toInt()
            var eliminado = false

            for (i in conciertos.indices) {
                if (conciertos[i]?.codigo == codigo) {
                    conciertos[i] = null
                    eliminado = true
                    break
                }
            }

            if (eliminado) {
                Toast.makeText(this, "Concierto eliminado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Concierto no encontrado", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingresa el código del boleto", Toast.LENGTH_SHORT).show()
        }
    }

}