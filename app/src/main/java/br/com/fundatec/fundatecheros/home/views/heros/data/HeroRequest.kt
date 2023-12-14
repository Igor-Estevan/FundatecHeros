package br.com.fundatec.fundatecheros.home.views.heros.data

data class HeroRequest (
    val name: String,
    val description: String,
    val image: String,
    val characterType: String,
    val age: Int,
    val birthday: String?
)
