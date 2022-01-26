package com.example.custozo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.helper.widget.MotionEffect
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.net.URL
import com.example.custozo.MainActivity.Companion.number1


private const val REQUEST_CODE_IMAGE_PICK = 0
class UploadActivity : AppCompatActivity() {
    var curFIle: Uri? = null
    val imageRef = Firebase.storage.reference
    var image: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        val downloadButton = findViewById<Button>(R.id.downloadBtn)
        val ivImage = findViewById<ImageView>(R.id.profileImage)
        val enterTextFile = findViewById<EditText>(R.id.etText)
        val input = findViewById<EditText>(R.id.etTextRow)
        val inputSec = findViewById<EditText>(R.id.etTextSection)
        val finitoButton = findViewById<Button>(R.id.finish)

        finitoButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        ivImage.setOnClickListener {

            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)

            }
        }

        val btnUploadImage = findViewById<Button>(R.id.uploadButton)
        btnUploadImage.setOnClickListener {
            Glide.with(this)
                .load(enterTextFile.text.toString())
                .into(ivImage)
        }
        downloadButton.setOnClickListener {
            downloadImage(enterTextFile.text.toString())
        }

        val allSections = ArrayList<Fragen>()
        val db = Firebase.firestore
        val ref = db.collection("fragen").addSnapshotListener { snapshot, error ->

            if (error != null) {
                Log.w(MotionEffect.TAG, "Listen failed", error)
                return@addSnapshotListener
            }
            if (snapshot != null) {

                val documents = snapshot.documents
                documents.forEach {
                    val section = it.toObject(Fragen::class.java)
                    if (section != null) {
                        section.id = it.id
                        allSections.add(section)

                    }
                }
            }



        }

        var updates = hashMapOf<String, Any>()
        val docRef = db.collection("fragen").document(inputSec.text.toString())
        val deleteAllbtn = findViewById<Button>(R.id.deleteBtn)
        deleteAllbtn.setOnClickListener {

               updates = hashMapOf(
                   input.text.toString() to FieldValue.delete()
               )

            docRef.update(updates).addOnCompleteListener {  }
            /*
            for(item in allSections) {
                db.collection("fragen").document(item.id.toString())
            }

         */
        }


    }




    private fun downloadImage(filename: String) = CoroutineScope(Dispatchers.IO).launch{
        try {
            val ivImage = findViewById<ImageView>(R.id.profileImage)

            val maxDownloadSize = 5L* 1024 * 1024
            val bytes = imageRef.child("images/$filename").getBytes(maxDownloadSize).await()
            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            withContext(Dispatchers.Main){
                ivImage.setImageBitmap(bmp)

            }

        }catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(this@UploadActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun uploadImageToStorage(filename : String) = CoroutineScope(Dispatchers.IO).launch {
        try{
            curFIle?.let {
                imageRef.child("images/$filename").putFile(it).await()
                withContext(Dispatchers.Main){
                    Toast.makeText(this@UploadActivity, "Succes", Toast.LENGTH_LONG).show()
                }
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@UploadActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val ivImage = findViewById<ImageView>(R.id.profileImage)

        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data?.let {
                curFIle = it
                ivImage.setImageURI(it)
            }
        }
    }

    }

