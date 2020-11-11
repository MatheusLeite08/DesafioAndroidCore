package com.example.desafio_androidcore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_androidcore.adapters.PratosPrincipaisAdapter
import com.example.desafio_androidcore.classes.PratoPrincipal
import com.example.desafio_androidcore.classes.Restaurante
import kotlinx.android.synthetic.main.activity_cardapio.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_register.*
import java.util.ArrayList

class CardapioActivity : AppCompatActivity(), PratosPrincipaisAdapter.onPratosPrincipaisClickListener {
    private val pratosList = getPratosPrincipais()
    private val adapter = PratosPrincipaisAdapter(pratosList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardapio)

        //Instanciando a toolbar da CardapioActivity
        setSupportActionBar(toolbar_cardapioPage)

        toolbar_cardapioPage.setNavigationOnClickListener{
            callHomePage()
        }

        //Deserialização do objeto restaurante
        val restaurante = intent.getSerializableExtra("restaurante") as? Restaurante

        //Adaptação do nome e da imagem do restaurante na CardapioActivity a partir do objeto recebido da HomeActivity
        iv_restauranteImage_cardapio.setImageResource(restaurante!!.image)
        tv_restauranteName_cardapio.setText(restaurante.name)

        //Iniciando o ReciclerView
        rv_pratosPrincipaisList.adapter = adapter
        rv_pratosPrincipaisList.layoutManager = GridLayoutManager(this, 2)
        rv_pratosPrincipaisList.setHasFixedSize(true)

    }

    fun callHomePage(){
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun getPratosPrincipais(): ArrayList<PratoPrincipal>{
        var prato1 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato2 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato3 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato4 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato5 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato6 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato7 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato8 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato9 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)
        var prato10 = PratoPrincipal("Salada com molho Gengibre", R.drawable.image4, R.string.pratoDetailsDescription)

        return arrayListOf(prato1, prato2, prato3, prato4, prato5, prato6, prato7, prato8, prato9, prato10)
    }

    override fun pratoPrincipalClick(position: Int) {
        var prato = pratosList.get(position)

        val intent = Intent(this, PratoDetailsActivity::class.java)

        //Serialização do objeto prato
        intent.putExtra("prato", prato)

        startActivity(intent)
    }
}