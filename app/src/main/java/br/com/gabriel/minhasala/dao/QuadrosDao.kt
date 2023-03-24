package br.com.gabriel.minhasala.dao

import br.com.gabriel.minhasala.model.Quadro

class QuadrosDao {

    fun adiciona(quadro: Quadro){
        quadros.add(quadro)
    }
    fun buscaTodos() : List<Quadro>{
        return quadros.toList()
    }

    companion object {
        private val quadros = mutableListOf<Quadro>()
    }
}