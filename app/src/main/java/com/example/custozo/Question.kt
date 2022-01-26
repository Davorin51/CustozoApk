package com.example.custozo

import android.widget.ImageView

data class Question(
   // val mainNumberID: Int,
    val id: Int? = null,
    val question: String,
    val image: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int?
        )