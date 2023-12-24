package br.com.fundatec.fundatecheros.home.views.home.domain

import br.com.fundatec.fundatecheros.home.views.heros.data.remote.HeroResponse

fun List<HeroResponse>.toModel(): List<HeroModel> {
    return map { hero ->
        HeroModel(
            id = hero.id,
            name = hero.name,
            image = hero.image,
            description = hero.description,
            date = hero.birthday.orEmpty(),
            age = hero.age
        )
    }
}

