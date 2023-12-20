package br.com.fundatec.fundatecheros.home.views.heros.presentation.model

import java.lang.IllegalArgumentException

enum class HeroType {

    HERO, VILLAIN;

    companion object{
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> HERO.name
                2 -> VILLAIN.name
                else -> throw IllegalArgumentException("Classificação Inválida")
            }
        }
    }

}