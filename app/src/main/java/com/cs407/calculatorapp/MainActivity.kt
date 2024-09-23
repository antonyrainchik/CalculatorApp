package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1 = findViewById<EditText>(R.id.editTextNumber)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)


        addButton.setOnClickListener{
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()
            val test = (userInput1 + userInput2).toString()
            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE",test)
            startActivity(intent)
        }
        subtractButton.setOnClickListener{
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()
            val test = (userInput1 - userInput2).toString()
            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE",test)
            startActivity(intent)
        }
        multiplyButton.setOnClickListener{
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()
            val test = (userInput1 * userInput2).toString()
            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE",test)
            startActivity(intent)
        }
        divideButton.setOnClickListener{
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()
            if(userInput2 == 0.0){
                val test = "DIVIDE BY 0 ERROR"
                val intent = Intent(this,CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE",test)
                startActivity(intent)
            }
            else{
                val test = (userInput1 / userInput2).toString()
                val intent = Intent(this,CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE",test)
                startActivity(intent)
            }

        }

        val intent = Intent(this, CalculatorActivity::class.java)


    }
}