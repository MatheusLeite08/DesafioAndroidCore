package com.example.desafio_androidcore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio_androidcore.classes.PratoPrincipal
import com.example.desafio_androidcore.classes.Restaurante
import kotlinx.android.synthetic.main.activity_cardapio.*
import kotlinx.android.synthetic.main.activity_pratodetails.*

class PratoDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratodetails)

        toolbar_pratoDetailsPage.setNavigationOnClickListener{
            callCardapioPage()
        }

        //Deserialização do objeto prato
        val prato = intent.getSerializableExtra("prato") as? PratoPrincipal

        //Adaptação do nome, imagem e decrição do prato na PratoDetailsActivity a partir do objeto recebido da CardapioActivity
        iv_pratoDetailsImage.setImageResource(prato!!.image)
        tv_pratoDetailsName.setText(prato.name)
        tv_pratoDetailsDescription.setText(prato.description)
    }

    //Para retornar para a CardapioActivity utiliza-se o método onBackPressed do botão Back da Navigation Bar
    fun callCardapioPage(){
        onBackPressed()
    }
}