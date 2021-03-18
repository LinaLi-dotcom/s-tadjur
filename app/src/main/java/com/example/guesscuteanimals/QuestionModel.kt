package com.example.guesscuteanimals

data class QuestionModel(
        val id: Int,
        val question: String,
        val image: Int,
        val optionOne: String,
        val optionTwo: String,
        val correctAnswer: Int
        )
