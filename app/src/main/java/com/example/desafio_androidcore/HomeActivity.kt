package com.example.desafio_androidcore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_androidcore.adapters.RestaurantesAdapter
import com.example.desafio_androidcore.classes.Restaurante
import kotlinx.android.synthetic.main.activity_home.*
import java.util.ArrayList

class HomeActivity : AppCompatActivity(), RestaurantesAdapter.onRestauranteClickListener {
    private var restaurantesList = getRestaurantesList()
    private val adapter = RestaurantesAdapter(restaurantesList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Iniciando o ReciclerView
        rv_restaurantesList.adapter = adapter
        rv_restaurantesList.layoutManager = LinearLayoutManager(this)
        rv_restaurantesList.setHasFixedSize(true)

    }

    fun getRestaurantesList(): ArrayList<Restaurante>{
        val restaurante1 = Restaurante("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image1)
        val restaurante2 = Restaurante("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image4)
        val restaurante3 = Restaurante("Outback - Moema", "Av. Moaci, 187- Moema, São Paulo", "Fecha às 00:00", R.drawable.image5)
        val restaurante4 = Restaurante("Sí Señor!", "Alameda Juaperi, 626 - Moema, São Paulo", "Fecha às 01:00", R.drawable.image3)

        return arrayListOf(restaurante1, restaurante2, restaurante3, restaurante4)
    }

    override fun restauranteClick(position: Int) {
        val restaurante = restaurantesList.get(position)

        val intent = Intent(this, CardapioActivity::class.java)

        //Serialização do objeto restaurante
        intent.putExtra("restaurante", restaurante)

        startActivity(intent)
    }

    //Ao clicar no botão Back da Navigation Bar na HomeActivity sempre vai voltar para a LoginActivity
    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}