package com.example.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var genProbBut: Button
    private lateinit var answerEdit: EditText
    private lateinit var questionsDoneTextView: TextView
    private lateinit var Number1Text: TextView
    private lateinit var Number2Text: TextView
    private lateinit var SymbolText: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionsDoneTextView = findViewById<TextView>(R.id.QuestionsDone)
        Number1Text = findViewById<TextView>(R.id.Num1)
        Number2Text = findViewById<TextView>(R.id.Num2)
        SymbolText = findViewById<TextView>(R.id.Symbol)


        submitButton = findViewById<Button>(R.id.Submit)
        genProbBut = findViewById<Button>(R.id.GenProbs)
        answerEdit = findViewById<EditText>(R.id.answer)

        var count = 0
        var ResultList = List(10) {null}
        var AorS = 8
        var choice = ""



        submitButton.setOnClickListener{
            val userAnswer = answerEdit.text.toString().toInt()
        }

        genProbBut.setOnClickListener{
            genProbBut.isEnabled = false
            while (count < 10) {
                SetRound()
                count++
                questionsDoneTextView.text = count.toString()
            }

        }

        fun SetRound() {
            Number1Text.text = (1..99).random().toString()
            Number2Text.text = (1..20).random().toString()
            AorS = (1..2).random()
            if(AorS == 1)
                choice = "+"
            else
                choice = "-"
            SymbolText.text = choice

        }


    }
}