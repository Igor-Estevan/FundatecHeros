package br.com.fundatec.fundatecheros.home.views.heros.domain

import br.com.fundatec.fundatecheros.home.views.heros.data.remote.HeroResponse
import br.com.fundatec.fundatecheros.home.views.heros.data.repository.HeroRepository

class HeroUseCase {

    private val repository by lazy {
        HeroRepository()
    }

    suspend fun createHero(
        name: String,
        description: String,
        image: String,
        characterType: String,
        age: Int,
        birthday: String?,

        ): Boolean {
        return repository.createHero(
            name = name,
            description = description,
            image = image,
            characterType = characterType,
            age = age,
            birthday = null,
        )
    }

    suspend fun listHero(): List<HeroResponse> {
        return repository.listHero();
    }

}