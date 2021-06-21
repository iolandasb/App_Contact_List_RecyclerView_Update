package com.example.exercicio_aula_17

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contato.view.*

class ContatosAdapter(val context: Context, var dataSet : MutableList<String>) : RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var texto = view.findViewById<TextView>(R.id.itemNome)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        val instanciaView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contato, parent, false)
        return ContatosViewHolder(instanciaView)
    }

    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        holder.texto.text = dataSet[position]
        holder.itemView.btnExcluir.setOnClickListener {
            frase.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = dataSet.size

    fun atualizarLista(listaFiltrada: MutableList<String>){
        dataSet = listaFiltrada
        notifyDataSetChanged()
    }

}
