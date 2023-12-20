package br.com.fundatec.fundatecheros.home.views.heros.data

import br.com.fundatec.fundatecheros.home.views.heros.presentation.model.UniverseType
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroRequest(
    val name: String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: String?
)
