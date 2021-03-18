package com.example.guesscuteanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.guesscuteanimals.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBTN = findViewById<Button>(R.id.start_BTN)

        startBTN.setOnClickListener {
            val scoreTV = findViewById<TextView>(R.id.scoreTV)
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}