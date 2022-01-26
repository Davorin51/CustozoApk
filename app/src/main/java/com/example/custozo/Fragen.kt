package com.example.custozo

import android.graphics.Bitmap

data class Fragen(

    var id: String? = null,
    var question: String? = null,
    val correctQuestion: Int? = null,
    val optionOne: String? = null,
    val optionTwo: String?= null,
    val optionThree: String?= null,
    val optionFour: String?= null,
    val image : String? = null



    )


