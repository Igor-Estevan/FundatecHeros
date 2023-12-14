package br.com.fundatec.fundatecheros.home.views.heros.presentation.model

import java.lang.IllegalArgumentException

enum class HeroType {

    Heroi, Vilao;

    companion object{
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> Heroi.name
                2 -> Vilao.name
                else -> throw IllegalArgumentException("Classificação Inválida")
            }
        }
    }

}