package com.example.pm1u2examen17100186

object Datos {
    val arrTransferencias : ArrayList<transferencia> = arrayListOf()
}

data class transferencia(val numTarjeta: String, val cantidad: Double, val nombreTarjeta: String){

    val imagen =
            if(nombreTarjeta == "visa") R.drawable.visa
            else if(nombreTarjeta == "mastercard") R.drawable.mastercard
            else if(nombreTarjeta == "american") R.drawable.american
            else R.drawable.tarjeta
}