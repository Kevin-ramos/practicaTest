package com.ramoskevin.practicatest

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import java.io.BufferedReader

class MainActivity2 : AppCompatActivity() {
    lateinit var extra : TextView
    lateinit var volver: Button

    private val segundaPantallaResultado =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                if (result.data!!.hasExtra("RESULT_TEXT")!!){
                    extra.setText(result.data?.getStringExtra("RESULT_TEXT")?: "No Result Provided")
                }
            }

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        extra = findViewById(R.id.textView)
        volver = findViewById(R.id.button3)




        var extras = intent.extras
        var numero = extras?.getInt("NuevoValor")
        extra.text = numero.toString()



        volver.setOnClickListener {
            val intencion = Intent(this,MainActivity::class.java).apply {
                putExtra("valor",25)

            }
            segundaPantallaResultado.launch(intencion)
        }

    }

}