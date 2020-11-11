package com.example.desafio_androidcore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_androidcore.R
import com.example.desafio_androidcore.classes.Restaurante
import kotlinx.android.synthetic.main.item_restaurante.view.*
import java.util.ArrayList

class RestaurantesAdapter(var restaurantesList: List<Restaurante>, val listener: onRestauranteClickListener): RecyclerView.Adapter<RestaurantesAdapter.RestaurantesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantesViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_restaurante, parent, false)
        return RestaurantesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantesViewHolder, position: Int) {
        val currentItem: Restaurante = restaurantesList[position]

        holder.restauranteName.setText(currentItem.name)
        holder.restauranteAddress.setText(currentItem.address)
        holder.restauranteCloseAt.setText(currentItem.closeAt)
        holder.restauranteImage.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return restaurantesList.size
    }

    interface onRestauranteClickListener{
        fun restauranteClick(position: Int)
    }

    inner class RestaurantesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val restauranteName: TextView = itemView.findViewById(R.id.tv_restauranteName)
        val restauranteAddress: TextView = itemView.findViewById(R.id.tv_restauranteAddress)
        val restauranteCloseAt: TextView = itemView.findViewById(R.id.tv_restauranteCloseAt)
        val restauranteImage: ImageView = itemView.findViewById(R.id.iv_restauranteImage)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.restauranteClick(position)
        }
    }
}