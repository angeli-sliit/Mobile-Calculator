package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.Modules.Calculator

class MainActivity : AppCompatActivity() {

    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
    }

    fun buttonClick(v: View) {
        var ans = 0.0
        try {
            val number1 = edtNumber1.text.toString().toDouble()
            val number2 = edtNumber2.text.toString().toDouble()
            val calculator = Calculator(number1, number2)

            when (v.id) {
                R.id.btnPlus -> ans = calculator.add()
                R.id.btnMinus -> ans = calculator.subtract()
                R.id.btnMultiply -> ans = calculator.multiply()
                R.id.btnDivide -> ans = calculator.divide()
            }

            // Navigate to ActivityDisplay
            val intent = Intent(this, ActivityDisplay::class.java)
            intent.putExtra("answer", ans)
            startActivity(intent)
        } catch (e: NumberFormatException) {
            // Handle invalid input
            edtNumber1.error = "Invalid input"
            edtNumber2.error = "Invalid input"
        }
    }
}