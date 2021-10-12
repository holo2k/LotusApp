package com.example.lotusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignInActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email=findViewById(R.id.editTextTextEmailAddress)
        password=findViewById(R.id.editTextTextPassword)
    }

    fun signin(view: android.view.View)
    {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        else
        {
         val alert = AlertDialog.Builder(this)
             .setTitle("Ошибка")
             .setMessage("У вас есть незаполненные поля")
             .setPositiveButton("OK",null)
             .create()
             .show()
        }
    }
}