package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val save = findViewById<ImageView>(R.id.save)
        val exit = findViewById<ImageView>(R.id.exit)

        save.setOnClickListener{
            val txtquestion = findViewById<EditText>(R.id.question).text.toString()
            val txtanswer = findViewById<EditText>(R.id.answer).text.toString()
            val data = Intent()
            data.putExtra("QUESTION_KEY", txtquestion)
            data.putExtra("ANSWER_KEY",txtanswer)

            setResult(RESULT_OK,data)
            finish()

        }
        exit.setOnClickListener{
            finish()
        }



        //        findViewById<View>(R.id.myButton).setOnClickListener {
//            val intent = Intent(this, EndingActivity::class.java)
//            startActivity(intent)
//        }
    }
}