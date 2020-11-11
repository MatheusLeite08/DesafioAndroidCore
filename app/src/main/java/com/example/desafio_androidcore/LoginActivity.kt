package com.example.desafio_androidcore

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Instanciando a toolbar da LoginActivity
        setSupportActionBar(toolbar_loginPage)

        button_login.setOnClickListener{
            callHomePage()
        }

        buttonregister_loginPage.setOnClickListener{
            callRegisterPage()
        }
    }

    fun callHomePage(){
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun callRegisterPage(){
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}