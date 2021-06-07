package com.example.pm1u2examen17100186

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransferenciaAdapter(private val listener: (transferencia) -> Unit) : RecyclerView.Adapter<TransferenciaAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val numTarjeta: TextView = view.findViewById(R.id.txtNumeroTarjeta)
        val cantidad: TextView = view.findViewById(R.id.txtCantidad)
        val imagen:ImageView = view.findViewById(R.id.imgImagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transferencia_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numTarjeta.text = "# Tarjeta: ${Datos.arrTransferencias.get(position).numTarjeta}"
        holder.cantidad.text = "$${Datos.arrTransferencias.get(position).cantidad} pesos"
        holder.imagen.setImageResource(Datos.arrTransferencias.get(position).imagen)

        holder.itemView.setOnClickListener {
            listener(Datos.arrTransferencias.get(position))
        }
    }
    override fun getItemCount(): Int {
        return Datos.arrTransferencias.size
    }
}