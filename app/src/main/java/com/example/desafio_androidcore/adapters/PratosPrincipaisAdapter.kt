package com.example.desafio_androidcore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_androidcore.R
import com.example.desafio_androidcore.classes.PratoPrincipal
import com.example.desafio_androidcore.classes.Restaurante

class PratosPrincipaisAdapter(var pratosList: List<PratoPrincipal>, val listener: onPratosPrincipaisClickListener): RecyclerView.Adapter<PratosPrincipaisAdapter.PratosPrincipaisViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratosPrincipaisViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_pratoprincipal, parent, false)
        return PratosPrincipaisViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratosPrincipaisViewHolder, position: Int) {
        val currentItem: PratoPrincipal = pratosList[position]

        holder.pratoPrincipalName.setText(currentItem.name)
        holder.pratoPrincipalImage.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return pratosList.size
    }

    interface onPratosPrincipaisClickListener{
        fun pratoPrincipalClick(position: Int)
    }

    inner class PratosPrincipaisViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val pratoPrincipalName: TextView = itemView.findViewById(R.id.tv_pratoName)
        val pratoPrincipalImage: ImageView = itemView.findViewById(R.id.iv_pratoImage)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.pratoPrincipalClick(position)
        }
    }
}