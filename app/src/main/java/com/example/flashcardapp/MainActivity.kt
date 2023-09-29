package com.example.flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var genProbBut: Button
    private lateinit var answerEdit: EditText
    private lateinit var questionsDoneTextView: TextView
    private lateinit var Number1Text: TextView
    private lateinit var Number2Text: TextView
    private lateinit var SymbolText: TextView

    private var submitted = false
    private var userAnswer = 0

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


        submitButton.setOnClickListener{
            val userAnswer = answerEdit.text.toString().toInt()
            submitted = true
        }

        genProbBut.setOnClickListener{
            var count = 0
            var answer = 0
            var ResultList = MutableList(10) { false }
            genProbBut.isEnabled = false
            while (count < 10) {
                submitted = false
                answer = SetRound()
                while(!submitted){
                }
                ResultList[count] = answer == userAnswer
                count++
                questionsDoneTextView.text = count.toString() + 1
            }

        }


    }
    fun SetRound(): Int {
        var AorS = 8
        var answer = 0
        var onenum = 0
        var twonum = 0
        onenum = (1..99).random()
        Number1Text.text = onenum.toString()
        twonum = (1..20).random()
        Number2Text.text = twonum.toString()
        AorS = (1..2).random()
        if(AorS == 1) {
            SymbolText.text = "+"
            return (onenum + twonum)
        }else{
            SymbolText.text = "-"
            return (onenum - twonum)
        }
    }
}