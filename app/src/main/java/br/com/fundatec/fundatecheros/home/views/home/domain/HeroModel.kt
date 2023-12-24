package br.com.fundatec.fundatecheros.home.views.home.domain

import java.io.Serializable

data class HeroModel(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val date: String,
    val age: Int
) : Serializable