package com.example.guesscuteanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.guesscuteanimals.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val scoreTV = findViewById<TextView>(R.id.scoreTV)
        val finishBTN = findViewById<Button>(R.id.finishBTN)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correntAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        scoreTV.text = "Score is $correntAnswer out of $totalQuestions "
        finishBTN.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}