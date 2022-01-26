package com.example.custozo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import com.example.custozo.MainActivity.Companion.inputString1
import com.example.custozo.MainActivity.Companion.inputString2
import com.example.custozo.MainActivity.Companion.inputString3
import com.example.custozo.MainActivity.Companion.inputString4
import com.example.custozo.MainActivity.Companion.inputString5
import com.example.custozo.MainActivity.Companion.inputString6
import com.example.custozo.MainActivity.Companion.inputString7
import com.example.custozo.MainActivity.Companion.inputString8
import com.example.custozo.MainActivity.Companion.inputString9
import com.example.custozo.MainActivity.Companion.inputString10
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import java.nio.IntBuffer
import kotlin.properties.Delegates
import com.example.custozo.MainActivity.Companion.number1


object Constants {





    val imageRef = Firebase.storage.reference


    const val USER_NAME: String = "user name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    val questionList = ArrayList<Question>()
    fun getQuestions(): ArrayList<Question> {

        var id: Int = 0





        val collRef = FirebaseFirestore.getInstance()


        val que1 = Question(
            1,
            question = "What flag is it?",
            image = "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/1200px-Flag_of_Brazil.svg.png",
            optionOne = "Argentina",
            optionTwo = "Austria",
            optionThree = "Brazil",
            optionFour = "Germany",
            3
        )

        questionList.add(que1)

/*
        val que2 = Question(
            2,
            "Whose country this flag belongs?",
           image = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Flag_of_Austria.svg/1024px-Flag_of_Austria.svg.png",
            optionOne = "Argentina",
            optionTwo = "Austria",
            optionThree = "Brazil",
            optionFour = "Germany",
            2
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "Whose country this flag belongs?",
            image = "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/1200px-Flag_of_Germany.svg.png",
            optionOne = "Argentina",
            optionTwo = "Austria",
            optionThree = "Brazil",
            optionFour = "Germany",
            4
        )
        questionList.add(que3)

        val que4 = Question(
            1,
            "Whose country this flag belongs?",
            image = "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/1200px-Flag_of_Germany.svg.png",
            optionOne = "Argentina",
            optionTwo = "Austria",
            optionThree = "Brazil",
            optionFour = "Germany",
            1
        )
        questionList.add(que4)

        val que5 = Question(
            2,
            "Whose country this flag belongs?",
            image = "https://www.advantour.com/russia/images/symbolics/russia-flag.jpg",
            optionOne = "Argentina",
            optionTwo = "Russia",
            optionThree = "England",
            optionFour = "Germany",
            2
        )
        questionList.add(que5)
/*
        val que6 = Question(
            4,
            "Whose country this flag belongs?",
           image = "https://cdn.britannica.com/36/4336-004-6BD81071/Flag-Spain.jpg",
            optionOne = "Argentina",
            optionTwo = "Austria",
            optionThree = "Brazil",
            optionFour = "Spain",
            4
        )
        questionList.add(que6)

 */
/*
        val que7 = Question(
            1,
            "Whose country this flag belongs?",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/2560px-Flag_of_Croatia.svg.png",
            optionOne = "Argentina",
            optionTwo = "Austria",
            optionThree = "Croatia",
            optionFour = "Germany",
            3
        )


 */

        questionList.add(que7)
*/
val db = FirebaseFirestore.getInstance()


/*
        val docRef = db.collection("users").document("Number")
        val numberQst : StringBuffer = StringBuffer()
        docRef.get().addOnSuccessListener { document ->

             numberQst.append(document.data!!.getValue("number"))



        }

 */

         var number2 : Int = 0
       /* docRef.get().addOnSuccessListener { document ->
            if(document != null){
                number1 = numberQst.append(document.data!!.getValue("number2")).toString().toInt()

            }
        }

        */


        if(number1 == 3) {
            getData1()
            getData2(inputString2)
            getData3()
        }

        else if(number1 == 4){
            getData1()
            getData2(inputString2)
            getData3()
            getData4()
        }
        else if(number1 == 5){
            getData1()
            getData2(inputString2)
            getData3()
            getData4()
            getData5()
        }
        else if(number1 == 6)
        {
            getData1()
            getData2(inputString2)
            getData3()
            getData4()
            getData6()
        }


        else {
            print("not found")
        }




        return questionList
    }

    fun getData1() {

        val key = Firebase.database.reference.child("fragen").push().key

        val db = FirebaseFirestore.getInstance()

        var docRef = db.collection("fragen").document(inputString1)

        val result: StringBuffer = StringBuffer()
        val result1: StringBuffer = StringBuffer()
        val result2: StringBuffer = StringBuffer()
        val result3: StringBuffer = StringBuffer()
        val result4: StringBuffer = StringBuffer()
        val result5: StringBuffer = StringBuffer()
        val result6 : StringBuffer = StringBuffer()



        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                result.append(document.data!!.getValue("question"))
                result1.append(document.data!!.getValue("optionOne"))
                result2.append(document.data!!.getValue("optionTwo"))
                result3.append(document.data!!.getValue("optionThree"))
                result4.append(document.data!!.getValue("optionFour"))
                result5.append(document.data!!.getValue("correctQuestion"))
                result6.append(document.data!!.getValue("image"))
            }
            val que6 = Question(2, result.toString(), result6.toString(), result1.toString(), result2.toString(), result3.toString(), result4.toString(), result5.toString().toInt())
            questionList.add(que6)
        }



    }

    fun getData2(filename: String) {
        val db = FirebaseFirestore.getInstance()



        var docRef = db.collection("fragen").document(filename)
        val result: StringBuffer = StringBuffer()
        val result1: StringBuffer = StringBuffer()
        val result2: StringBuffer = StringBuffer()
        val result3: StringBuffer = StringBuffer()
        val result4: StringBuffer = StringBuffer()
        val result5: StringBuffer = StringBuffer()
        val result6 : StringBuffer = StringBuffer()


        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                result.append(document.data!!.getValue("question"))
                result1.append(document.data!!.getValue("optionOne"))
                result2.append(document.data!!.getValue("optionTwo"))
                result3.append(document.data!!.getValue("optionThree"))
                result4.append(document.data!!.getValue("optionFour"))
                result5.append(document.data!!.getValue("correctQuestion"))
                result6.append(document.data!!.getValue("image"))
            }
            val que7 = Question(
                3,
                result.toString(),
                result6.toString(),
                result1.toString(),
                result2.toString(),
                result3.toString(),
                result4.toString(),
                result5.toString().toInt()
            )
            questionList.add(que7)
        }
    }
        fun getData3() {
            val db = FirebaseFirestore.getInstance()

            var docRef = db.collection("fragen").document(inputString3)
            val result: StringBuffer = StringBuffer()
            val result1: StringBuffer = StringBuffer()
            val result2: StringBuffer = StringBuffer()
            val result3: StringBuffer = StringBuffer()
            val result4: StringBuffer = StringBuffer()
            val result5: StringBuffer = StringBuffer()
            val result6: StringBuffer = StringBuffer()


            docRef.get().addOnSuccessListener { document ->
                if (document != null) {
                    result.append(document.data!!.getValue("question"))
                    result1.append(document.data!!.getValue("optionOne"))
                    result2.append(document.data!!.getValue("optionTwo"))
                    result3.append(document.data!!.getValue("optionThree"))
                    result4.append(document.data!!.getValue("optionFour"))
                    result5.append(document.data!!.getValue("correctQuestion"))
                    result6.append(document.data!!.getValue("image"))
                }
                val que8 = Question(4, result.toString(), result6.toString(), result1.toString(), result2.toString(), result3.toString(), result4.toString(), result5.toString().toInt())
                questionList.add(que8)
            }



        }

    fun getData4() {
        val db = FirebaseFirestore.getInstance()

        var docRef = db.collection("fragen").document(inputString4)
        val result: StringBuffer = StringBuffer()
        val result1: StringBuffer = StringBuffer()
        val result2: StringBuffer = StringBuffer()
        val result3: StringBuffer = StringBuffer()
        val result4: StringBuffer = StringBuffer()
        val result5: StringBuffer = StringBuffer()
        val result6: StringBuffer = StringBuffer()



        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                result.append(document.data!!.getValue("question"))
                result1.append(document.data!!.getValue("optionOne"))
                result2.append(document.data!!.getValue("optionTwo"))
                result3.append(document.data!!.getValue("optionThree"))
                result4.append(document.data!!.getValue("optionFour"))
                result5.append(document.data!!.getValue("correctQuestion"))
                result6.append(document.data!!.getValue("image"))
            }
            val que = Question(
                5,
                result.toString(),
                result6.toString(),
                result1.toString(),
                result2.toString(),
                result3.toString(),
                result4.toString(),
                result5.toString().toInt()
            )
            questionList.add(que)
        }
    }

        fun getData5() {
            val db = FirebaseFirestore.getInstance()

            var docRef = db.collection("fragen").document(inputString5)
            val result: StringBuffer = StringBuffer()
            val result1: StringBuffer = StringBuffer()
            val result2: StringBuffer = StringBuffer()
            val result3: StringBuffer = StringBuffer()
            val result4: StringBuffer = StringBuffer()
            val result5: StringBuffer = StringBuffer()
            val result6: StringBuffer = StringBuffer()



            docRef.get().addOnSuccessListener { document ->
                if (document != null) {
                    result.append(document.data!!.getValue("question"))
                    result1.append(document.data!!.getValue("optionOne"))
                    result2.append(document.data!!.getValue("optionTwo"))
                    result3.append(document.data!!.getValue("optionThree"))
                    result4.append(document.data!!.getValue("optionFour"))
                    result5.append(document.data!!.getValue("correctQuestion"))
                    result6.append(document.data!!.getValue("image"))
                }
                val que = Question(6, result.toString(),   result6.toString(), result1.toString(), result2.toString(), result3.toString(), result4.toString(), result5.toString().toInt())
                questionList.add(que)
            }

    }


    fun getData6() {
        val db = FirebaseFirestore.getInstance()

        var docRef = db.collection("fragen").document(inputString5)
        val result: StringBuffer = StringBuffer()
        val result1: StringBuffer = StringBuffer()
        val result2: StringBuffer = StringBuffer()
        val result3: StringBuffer = StringBuffer()
        val result4: StringBuffer = StringBuffer()
        val result5: StringBuffer = StringBuffer()
        val result6: StringBuffer = StringBuffer()



        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                result.append(document.data!!.getValue("question"))
                result1.append(document.data!!.getValue("optionOne"))
                result2.append(document.data!!.getValue("optionTwo"))
                result3.append(document.data!!.getValue("optionThree"))
                result4.append(document.data!!.getValue("optionFour"))
                result5.append(document.data!!.getValue("correctQuestion"))
                result6.append(document.data!!.getValue("image"))
            }
            val que = Question(7, result.toString(),   result6.toString(), result1.toString(), result2.toString(), result3.toString(), result4.toString(), result5.toString().toInt())
            questionList.add(que)
        }

    }

    fun readData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("fragen")

            .get()
            .addOnCompleteListener {
                val result: StringBuffer = StringBuffer()
                val result1: StringBuffer = StringBuffer()
                val result2: StringBuffer = StringBuffer()
                val result3: StringBuffer = StringBuffer()
                val result4: StringBuffer = StringBuffer()


                if (it.isSuccessful) {

                    for (document in it.result!!) {
                        result.append(document.data.getValue("question"))
                            result.append()

                    }

                    val que = Question(
                        8,
                        question = result.toString(),
                        image = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/2560px-Flag_of_Croatia.svg.png",
                        optionOne = "1810",
                        optionTwo = "1900",
                        optionThree = "1234",
                        optionFour = "989",
                        correctAnswer = 4
                    )
                    questionList.add(que)
                }
            }

    }


}


