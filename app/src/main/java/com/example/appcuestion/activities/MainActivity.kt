package com.example.appcuestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.translation.ViewTranslationRequest
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.appcuestion.R
import com.example.appcuestion.model.Pregunta
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    var preguntas=ArrayList<Pregunta>()
    var posicionActual = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //numero()
        //factorial()
        //area()

        cargarPreguntas()

        mostratPreguntas()


        val btnVerdad=findViewById<android.view.View>(R.id.btnVerdadero)

        btnVerdad.setOnClickListener{
            if(preguntas[posicionActual].respuesta)
                Toast.makeText(this,"LA RESPUESTA ES CORRECTA", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"LA RESPUESTA ES INCORRECTO", Toast.LENGTH_SHORT).show()
        }

        val btnIncorrecto=findViewById<android.view.View>(R.id.btnFalso)
        btnIncorrecto.setOnClickListener {
            if (preguntas[posicionActual].respuesta == false)
                Toast.makeText(this, "LA RESPUESTA ES CORRECTA", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"LA RESPUESTA ES INCORRECTO", Toast.LENGTH_SHORT).show()
        }


        val btnnext=findViewById<Button>(R.id.btnSiguiente)
        btnnext.setOnClickListener{
            try{
                posicionActual ++
                mostratPreguntas()

            }catch (e:Exception){
                Toast.makeText(this, "NO EXISTE MAS PREGUNTAS", Toast.LENGTH_SHORT).show()
            }

        }

        val btnatras=findViewById<Button>(R.id.btnAtras)
        btnatras.setOnClickListener{
            try{
                posicionActual --
                mostratPreguntas()

            }catch (e:Exception){
                Toast.makeText(this, "NO EXISTE MAS PREGUNTAS", Toast.LENGTH_SHORT).show()
            }

        }

    }


    private fun mostratPreguntas() {
        val textoPregunta=findViewById<TextView>(R.id.tvPregunta)
        textoPregunta.text=preguntas[posicionActual].enunciado

    }

    fun cargarPreguntas(){
        preguntas.add(Pregunta("caracas es la capital de venezuela", true))
        preguntas.add(Pregunta("piura es un departamento que pertenece a ecuador", false))
        preguntas.add(Pregunta("Uruguay es un pais Latinoamericano", true))
        preguntas.add(Pregunta("Lima es la capital de chile", false))

    }


    //EJERCICIO 01
    fun numero(){
        for (i in 50 downTo  0 step 2){
            println("valor: $i")
        }
    }

    //EJERCICIO 02
    fun factorial(){
        val num=5
        var facto:Long=1
        for (i in 1..num){
            facto *= i.toLong()
        }
        println("El factorial de: $num : $facto")
    }

    //EJERCICIO 03
    fun area(){

        var base = 6
        var altura =6

        var area =(base * altura)/2
        println("El area del triangulo es $area")

    }



}