package com.example.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


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