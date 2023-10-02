package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginScreen : AppCompatActivity() {

    private lateinit var submitButton: Button
    private var validUsername = "stevejobs"
    private var validPass = "thinkdifferent"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`login`)

        var input_username = findViewById<EditText>(R.id.input_username)
        var input_password = findViewById<EditText>(R.id.input_password)
        submitButton = findViewById(R.id.loginbutton)



        submitButton.setOnClickListener{
            var inputtedUser = input_username.text.toString()
            var inputtedPass = input_password.text.toString()

            if ((inputtedUser.equals(validUsername)) && (inputtedPass.equals(validPass))) {
                Toast.makeText(
                    this,
                    "Credentials accepted. Welcome!",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(
                    this@LoginScreen,
                    MainActivity::class.java
                )
                intent.putExtra("Text", "initiating FLashcards")
                startActivity(intent)
            }
            else {
                Toast.makeText(
                    this,
                    "Invalid username/password. Try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }

}