package com.example.custozo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuestionsNumber : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_number)


        val returnToQuiz = findViewById<Button>(R.id.NextToQuiz)
        val saveNumbers = findViewById<Button>(R.id.SaveNumbers)
        val etTextNumbers = findViewById<EditText>(R.id.QuestionNumber)
        val saveNumbers2 = findViewById<Button>(R.id.SaveNumbers2)


        returnToQuiz.setOnClickListener {
            val intentOne = Intent(this, CreateQuiz::class.java)
            startActivity(intentOne)
            finish()
        }

        val db = Firebase.firestore


saveNumbers.setOnClickListener {

    val number1 = Number(
        etTextNumbers.text.toString().toInt()
    )
    db.collection("users")
        .document("Number")
        .set(number1)

   /* val intentSave = Intent(this@QuestionsNumber, MainActivity::class.java)
    intentSave.putExtra("numbers", etTextNumbers.text.toString())
    Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show()

    */
}
        saveNumbers2.setOnClickListener {
            val number2 = Number(
                etTextNumbers.text.toString().toInt()
            )
            db.collection("users")
                .document("Numbers")
                .set(number2)
        }
    }


}