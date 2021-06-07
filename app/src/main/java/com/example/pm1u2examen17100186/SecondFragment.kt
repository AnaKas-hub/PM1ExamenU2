package com.example.pm1u2examen17100186

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtnumTarjeta:EditText = view.findViewById(R.id.edtNumTarjeta)
        val edtfechaVencimiento:EditText = view.findViewById(R.id.edtFechaVencimiento)
        val edtvcc:EditText = view.findViewById(R.id.edtCVV)
        val edtcantidad:EditText = view.findViewById(R.id.edtCantidad)
        val rdbVisa:RadioButton = view.findViewById(R.id.rdbVisa)
        val rdbMaster:RadioButton = view.findViewById(R.id.rdbMastercard)
        val rdbAmerican:RadioButton = view.findViewById(R.id.rdbAmerican)
        val btnTransferir:Button = view.findViewById(R.id.btnTransferir)
        val fab:FloatingActionButton = view.findViewById(R.id.fabEnviar)

        btnTransferir.setOnClickListener {
            val numTarjeta = edtnumTarjeta.text.toString()
            val cantidad = edtcantidad.text.toString().toDouble()
            var nombreTarjeta =""

            if(rdbVisa.isChecked){
                nombreTarjeta="visa"
            }else if(rdbMaster.isChecked){
                nombreTarjeta="mastercard"
            }else if (rdbAmerican.isChecked){
                nombreTarjeta="american"
            }else{
                nombreTarjeta="otro"
            }

            val miTransferencia = transferencia(numTarjeta, cantidad, nombreTarjeta)
            Datos.arrTransferencias.add(miTransferencia)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        fab.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND //envia una accion
                putExtra(Intent.EXTRA_TEXT, "Se le transfirio $: ${edtcantidad.text.toString()}, a la tarjeta ${edtnumTarjeta.text.toString()}.")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }
    }
}