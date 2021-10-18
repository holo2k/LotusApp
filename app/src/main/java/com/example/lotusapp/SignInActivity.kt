package com.example.lotusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lotusapp.retrofitConnections.Interface
import com.example.lotusapp.retrofitConnections.MyRetrofit
import com.example.lotusapp.retrofitConnections.login
import retrofit2.Call
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)
    }

    fun signin(view: android.view.View) {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            val log = MyRetrofit().getRetrofit()
            val getApi = log.create(Interface::class.java)
            val hashMap: HashMap<String,String> = HashMap<String,String>()
            hashMap.put("email",email.text.toString())
            hashMap.put("password",password.text.toString())
            val log_call:Call<Void> = getApi.getAuth(hashMap)
            log_call.enqueue(object:retrofit2.Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful)
                    {
                        val intent = Intent(this@SignInActivity,MenuActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@SignInActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
            Intent(this, MenuActivity::class.java)
        }
        else{
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}