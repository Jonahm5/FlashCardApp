package com.example.flashcardapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var genProbBut: Button
    private lateinit var answerEdit: EditText
    private lateinit var questionsDoneTextView: TextView
    private lateinit var Number1Text: TextView
    private lateinit var Number2Text: TextView
    private lateinit var SymbolText: TextView

    private var count = 0
    private var resultlist = mutableListOf<Boolean>()
    private var submitted = false
    private var userAnswer = 0
    private var num1 = 0
    private var num2 = 0
    private var Symbol = ""
    private var answer = 0

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
            if (answerEdit.text.isNotEmpty()){
                userAnswer = answerEdit.text.toString().toInt()
                submitted = true
                answerEdit.text.clear()
            } else{
                Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show()
            }

        }

        genProbBut.setOnClickListener{
            questionsDoneTextView.text = "0"
            count = 0
            resultlist.clear()
            genProbBut.isEnabled = false
            nextQ()
            }
        }

    private fun nextQ(){
        if (count < 10){
            submitted = false
            val answer = SetRound()
            Update()
            waitnow(answer)
        } else {
            val correct = resultlist.count{it}.toString()
            Toast.makeText(this,"You got $correct out of 10!", Toast.LENGTH_SHORT).show()
            genProbBut.isEnabled = true
        }
    }

    private fun Update(){
        Number1Text.text = num1.toString()
        Number2Text.text = num2.toString()
        SymbolText.text = Symbol
    }
    
    private fun waitnow(answer: Int){
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (submitted){
                resultlist.add(userAnswer == answer)
                count++
                questionsDoneTextView.text = (count).toString()
                nextQ()
            } else {
                waitnow(answer)
            }
        }, 100)
    }
    fun SetRound(): Int {

        val AorS = (1..2).random()
        val onenum = (1..99).random()
        val twonum = (1..20).random()
        num1 = onenum
        num2 = twonum

        if(AorS == 1){
            Symbol = "+"
            return (onenum + twonum)
        } else{
            Symbol = "-"
            return(onenum - twonum)
        }
    }
}
