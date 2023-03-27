package br.com.gabriel.minhasala.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabriel.minhasala.R
import br.com.gabriel.minhasala.databinding.QuadroItemBinding
import br.com.gabriel.minhasala.extensions.tentaCarregarImagem
import br.com.gabriel.minhasala.model.Quadro
import coil.load

class ListaQuadroAdapter(
    private val context: Context,
    quadros: List<Quadro>
) : RecyclerView.Adapter<ListaQuadroAdapter.ViewHolder>() {

    private val quadros = quadros.toMutableList()

    class ViewHolder(private val binding: QuadroItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(quadro: Quadro) {
            val nome = binding.quadroItemNome
            nome.text = quadro.nome
            val professor = binding.quadroItemProfessor
            professor.text = quadro.professor
            val dia = binding.quadroItemDia
            dia.text = quadro.dia
            val sala = binding.quadroItemSala
            sala.text = quadro.sala

           val visibilidade =  if(quadro.imagem != null){
                View.VISIBLE
            }else{
               View.GONE
           }
            binding.quadroItemImagem.visibility = visibilidade

            binding.quadroItemImagem.tentaCarregarImagem(quadro.imagem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = QuadroItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
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
