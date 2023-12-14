package br.com.fundatec.fundatecheros.home.views.heros.data.remote

data class HeroResponse(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val characterType: String,
    val age: Int,
    val birthday: String?
)