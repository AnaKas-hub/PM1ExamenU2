package com.example.pm1u2examen17100186

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        val usuario:EditText = findViewById(R.id.edtUsuario)
        val contrasena:EditText = findViewById(R.id.edtContrasena)
        val ingresar:Button = findViewById(R.id.btnLogin)

        ingresar.setOnClickListener {
            if (usuario.text.toString()=="ana" && contrasena.text.toString()=="17100186"){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                Snackbar.make(usuario,"Error, usuario o contraseña incorrecto",Snackbar.LENGTH_LONG).setAction("INFO", View.OnClickListener {
                    Toast.makeText(this,"Usuario: ana, Contraseña: 17100186", Toast.LENGTH_LONG).show()
                }).show()
            }
        }
    }
}