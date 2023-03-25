package br.com.gabriel.minhasala.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabriel.minhasala.R
import br.com.gabriel.minhasala.model.Quadro

class ListaQuadroAdapter(
    private val context: Context,
    quadros: List<Quadro>
) : RecyclerView.Adapter<ListaQuadroAdapter.ViewHolder>() {

    private val quadros = quadros.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(quadro: Quadro) {
            val nome = itemView.findViewById<TextView>(R.id.quadro_item_nome)
            nome.text = quadro.nome
            val professor = itemView.findViewById<TextView>(R.id.quadro_item_professor)
            professor.text = quadro.professor
            val dia = itemView.findViewById<TextView>(R.id.quadro_item_dia)
            dia.text = quadro.dia
            val sala = itemView.findViewById<TextView>(R.id.quadro_item_sala)
            sala.text = quadro.sala
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.quadro_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = quadros.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quadro = quadros[position]
        holder.vincula(quadro)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun atualiza(quadros: List<Quadro>) {
        this.quadros.clear()
        this.quadros.addAll(quadros)
        notifyDataSetChanged()
    }
}
