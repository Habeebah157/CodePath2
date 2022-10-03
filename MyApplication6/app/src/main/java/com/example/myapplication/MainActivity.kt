package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val flashCardQuestion = findViewById<TextView>(R.id.flashcard_question)

        val flashCardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashCardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val flashCardAnswer1 = findViewById<TextView>(R.id.answer1)
        val flashCardAnswer2 = findViewById<TextView>(R.id.answer2)
        val flashCardAnswer3 = findViewById<TextView>(R.id.answer3)
        val toggle = findViewById<ImageView>(R.id.toggle)
        val toggle2 = findViewById<ImageView>(R.id.toggle2)
        val add = findViewById<ImageView>(R.id.add)

        flashCardQuestion.setOnClickListener{
            flashCardQuestion.visibility = View.INVISIBLE
            flashCardAnswer.visibility = View.VISIBLE
        }
        flashCardAnswer.setOnClickListener {
            flashCardAnswer.visibility = View.INVISIBLE
            flashCardQuestion.visibility = View.VISIBLE
        }
        flashCardAnswer1.setOnClickListener {
            flashCardAnswer1.setBackgroundColor(getResources().getColor(R.color.green));
        }
        flashCardAnswer2.setOnClickListener {
            flashCardAnswer2.setBackgroundColor(getResources().getColor(R.color.red))
            flashCardAnswer1.setBackgroundColor(getResources().getColor(R.color.green))
        }
        flashCardAnswer3.setOnClickListener {
            flashCardAnswer3.setBackgroundColor(getResources().getColor(R.color.red))
            flashCardAnswer1.setBackgroundColor(getResources().getColor(R.color.green))
        }
        toggle.setOnClickListener {
            flashCardAnswer1.visibility = View.INVISIBLE
            flashCardAnswer2.visibility = View.INVISIBLE
            flashCardAnswer3.visibility = View.INVISIBLE
            toggle.visibility = View.INVISIBLE
            toggle2.visibility = View.VISIBLE
        }
        toggle2.setOnClickListener{
            flashCardAnswer1.visibility = View.VISIBLE
            flashCardAnswer2.visibility = View.VISIBLE
            flashCardAnswer3.visibility = View.VISIBLE
            toggle.visibility = View.VISIBLE
            toggle2.visibility = View.INVISIBLE
        }
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            val data:Intent? = result.data

           if(data != null){
               val questionString = data.getStringExtra("QUESTION_KEY")
               val answerString = data.getStringExtra("ANSWER_KEY")

               flashCardQuestion.text = questionString
               flashCardAnswer.text = answerString
//               Log.i("Paulina: MainActitivity", "question: $questionString")
           }

        }

        add.setOnClickListener{
            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)

        }
//


    }
}