package com.example.desafio_androidcore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Instanciando a toolbar da RegisterActivity
        setSupportActionBar(toolbar_registerPage)

        toolbar_registerPage.setNavigationOnClickListener{
            callLoginPage()
        }

        buttonregister_registerPage.setOnClickListener{
            callHomePage()
        }
    }

    fun callHomePage(){
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun callLoginPage(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}