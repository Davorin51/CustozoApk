package com.example.custozo

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase





class CreateQuiz : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quiz)
        val mainID = findViewById<EditText>(R.id.QuizMainID)

        val buttonEnd = findViewById<Button>(R.id.btnEnd)
        val buttonSave = findViewById<Button>(R.id.Save)
        val etQuizId = findViewById<EditText>(R.id.QuizID)
        val etQuestion = findViewById<EditText>(R.id.QuizQuestion)
        val etOptionOne = findViewById<EditText>(R.id.QuizOptionOne)
        val etOptionTwo = findViewById<EditText>(R.id.QuizOptionTwo)
        val etOptionThree = findViewById<EditText>(R.id.QuizOptionThree)
        val etOptionFour = findViewById<EditText>(R.id.QuizOptionFour)
        val etCorrectAnswer = findViewById<EditText>(R.id.QuizCorrectAnswer)
        val etImageLink = findViewById<EditText>(R.id.etImageLink)
        val questionNumber = findViewById<Button>(R.id.questionNumber)

        questionNumber.setOnClickListener {
            val intentJump = Intent(this, QuestionsNumber::class.java)
            startActivity(intentJump)
            finish()
        }

        val sendButton = findViewById<Button>(R.id.sendMain)
        var mainId: String = ""
        sendButton.setOnClickListener {
            val intent3 = Intent(this, UploadActivity::class.java)
            startActivity(intent3)
            finish()
        }

       // val intentConstant = Intent(this, Constants::class.java)
        //startActivity(intentConstant)


        buttonEnd.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)

            startActivity(intent2)
        }



        val db = Firebase.firestore

        val question: String = ""

        val sections = listOf("Section1", "Section2", "Section3", "Section4", "Section5")
/*
        var i = 0
        buttonSave.setOnClickListener {
            val fragen1 = Fragen(
                etQuizId.text.toString().toInt(),
                etQuestion.text.toString(),
                etCorrectAnswer.text.toString().toInt(),
                etOptionOne.text.toString(),
                etOptionTwo.text.toString(),
                etOptionThree.text.toString(),
                etOptionFour.text.toString()
            )
            for (item in sections) {

                db.collection("fragen")
                    .document(sections[i])
                    .set(fragen1)

            }
            i++
        }

*/

        buttonSave.setOnClickListener {
            if (etQuizId.text.toString().isEmpty() && etQuestion.text.toString().isEmpty()) {
                Toast.makeText(this, "You forgot ID or Question", Toast.LENGTH_SHORT).show()
            } else {
                val fragen1 = Fragen(
                    etQuizId.text.toString(),
                    etQuestion.text.toString(),
                    etCorrectAnswer.text.toString().toInt(),
                    etOptionOne.text.toString(),
                    etOptionTwo.text.toString(),
                    etOptionThree.text.toString(),
                    etOptionFour.text.toString(),
                    etImageLink.text.toString()
                )
                db.collection("fragen")
                    .document(mainID.text.toString())
                    .set(fragen1)

                Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show()
            }
        }
    }

}




