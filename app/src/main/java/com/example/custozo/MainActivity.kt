package com.example.custozo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.helper.widget.MotionEffect.TAG
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text
import com.firebase.ui.storage.images.FirebaseImageLoader
import com.google.firebase.database.core.Tag
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.lang.reflect.Array.get
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener





class MainActivity : AppCompatActivity() {

    companion object {

        var number1: Int = 0
        var inputString1: String = ""
        var inputString2: String = ""
        var inputString3: String = ""
        var inputString4: String = ""
        var inputString5: String = ""
        var inputString6: String = ""
        var inputString7: String = ""
        var inputString8: String = ""
        var inputString9: String = ""
        var inputString10: String = ""
    }

    /*fun readData(){
        val db = FirebaseFirestore.getInstance()
                db.collection("users")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful){
                    for(document in it.result!!){
                        result.append(document.data.getValue("first"))

                    }
                }
                val textView = findViewById<TextView>(R.id.textView)
                textView.setText(result)

            }

     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //var mainID : String? = null
        val storageReference = FirebaseStorage.getInstance().reference


//readData()
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("users").document("Number")
        val numberQst: StringBuffer = StringBuffer()
        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                number1 = numberQst.append(document.data!!.getValue("number")).toString().toInt()

            }
        }


        val value1 = intent.getStringExtra("section")




        val allSections = ArrayList<Fragen>()

        val ref = db.collection("fragen").addSnapshotListener { snapshot, error ->


            if(snapshot != null){

                val documents = snapshot.documents
                documents.forEach{
                    val section = it.toObject(Fragen::class.java)
                    if(section != null){
                        section.id = it.id
                        allSections.add(section)

                    }
                }



            }
            if(error != null){
                Log.w(TAG, "Listen failed", error)
                return@addSnapshotListener
            }

if(number1 == 3){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();

}
            else if(number1 == 4){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();

            }
else if(number1 == 5){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();
    inputString5 = allSections[4].id.toString();

}
else if(number1 == 6){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();
    inputString5 = allSections[4].id.toString();
    inputString6 = allSections[5].id.toString();

}
else if(number1 == 7){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();
    inputString5 = allSections[4].id.toString();
    inputString6 = allSections[5].id.toString();
    inputString7 = allSections[6].id.toString();

}
else if(number1 == 8){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();
    inputString5 = allSections[4].id.toString();
    inputString6 = allSections[5].id.toString();
    inputString7 = allSections[6].id.toString();
    inputString8 = allSections[7].id.toString();

}
else if(number1 == 9){
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();
    inputString5 = allSections[4].id.toString();
    inputString6 = allSections[5].id.toString();
    inputString7 = allSections[6].id.toString();
    inputString8 = allSections[7].id.toString();
    inputString9 = allSections[8].id.toString();

}
else{
    inputString1 = allSections[0].id.toString();
    inputString2 = allSections[1].id.toString();
    inputString3 = allSections[2].id.toString();
    inputString4 = allSections[3].id.toString();
    inputString5 = allSections[4].id.toString();
    inputString6 = allSections[5].id.toString();
    inputString7 = allSections[6].id.toString();
    inputString8 = allSections[7].id.toString();
    inputString9 = allSections[8].id.toString();
    inputString10 = allSections[9].id.toString();

}
            

        }

        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document: DocumentSnapshot? = task.getResult()
                if (document?.exists() == true) {

                } else {
                    Log.d(TAG, "No such document")
                }
            } else {
                //Log the error if the task is not successful
                Log.d(TAG, "get failed with ", task.exception)
            }
        }


        val btn_new = findViewById<Button>(R.id.button_quiz)

            btn_new.setOnClickListener {
                val intent1 = Intent(this, CreateQuiz::class.java)
                startActivity(intent1)
                finish()
            }
            val btn_start = findViewById<Button>(R.id.button_start)
            val et_name = findViewById<EditText>(R.id.et_name)



            btn_start.setOnClickListener {
                if (et_name.text.toString() != value1 && et_name.text.toString().isEmpty()) {
                    Toast.makeText(this, "Please try again", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, QuizQuestionsActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                    startActivity(intent)
                    finish()
                }
            }

        }
    }


