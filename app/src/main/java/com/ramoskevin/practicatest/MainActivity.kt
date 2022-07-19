package com.ramoskevin.practicatest

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var button9 : Button
    lateinit var button8 : Button
    lateinit var  delete: Button
    lateinit var constraintLayout : ConstraintLayout
    lateinit var editMensaje: EditText
    lateinit var funcion: Button
    lateinit var intentExplicito : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button9 = findViewById(R.id.button9)
        button8 = findViewById(R.id.button8)
        delete = findViewById(R.id.delete)
        /*Recuperar valor intent*/
        var valor = intent.getIntExtra("valor",0).toString()
        delete.text = valor
        constraintLayout = findViewById(R.id.principal)
        editMensaje = findViewById(R.id.editTextTextPersonName)
        funcion = findViewById(R.id.funcion)
        intentExplicito = findViewById(R.id.intentExplicito)
        button9.setOnClickListener {
            Toast.makeText(this,"Hola", Toast.LENGTH_LONG).show()
            var mensaje = editMensaje.text.toString()
            if( mensaje == ""){
                editMensaje.setError("Vacio")
            }else{
                button9.text = editMensaje.text.toString()

        }
        button8.setOnClickListener {
            Snackbar.make(constraintLayout,getString(R.string.app_name),Snackbar.LENGTH_LONG).setAction("Eliminar", {
                button9.visibility = View.INVISIBLE

            }).show()

        }
        delete.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Confirmacion")
            dialogBuilder.setMessage("Esta seguro de borrar?")
            dialogBuilder.setPositiveButton("Borrar", DialogInterface.OnClickListener{_,_ ->
                Toast.makeText(this,"Hola", Toast.LENGTH_LONG).show()
            })
            dialogBuilder.setNegativeButton("Cancelar",DialogInterface.OnClickListener{_,_ -> })
            dialogBuilder.create().show()

        }
            /*Intent explicito*/
        intentExplicito.setOnClickListener {

            val pantalla2 = Intent(this,MainActivity2::class.java)
            pantalla2.putExtra("NuevoValor",25)
            startActivity(pantalla2)

        }


       }

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"F",Toast.LENGTH_LONG).show()

    }
    /*Mensaje*/
    fun funcion(view: View){
        val intencion = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Bateria baja")
            type = "text/plain"
        }
        if(intencion.resolveActivity(packageManager) != null){
            startActivity(intencion)
        }
    }
    /*Navegador*/
    fun funcionWeb(view: View){
        val intentWeb = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse("http://www.google.com")

        }
        startActivity(intentWeb)
    }
    /*Llamada */
    fun llamada(view: View){
       val intentLlamada = Intent(Intent.ACTION_DIAL).apply {
           data = Uri.parse("tel:2125551212")
       }
        startActivity(intentLlamada)

    }



}