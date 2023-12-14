package br.com.fundatec.fundatecheros.home.views.heros.presentation.model

enum class UniverseType {

    MARVEL, DC;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> MARVEL.name
                2 -> DC.name
                else -> throw IllegalArgumentException("Universo inválido")
            }
        }
    }

}