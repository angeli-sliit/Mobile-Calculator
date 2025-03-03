package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityDisplay : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val txtAnswer: TextView = findViewById(R.id.txtAnswer)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Set the text to the TextView
        val answer = intent.getDoubleExtra("answer", 0.0)
        txtAnswer.text = answer.toString()

        // Set OnClickListener for the back button
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Close the current activity
        }
    }
}