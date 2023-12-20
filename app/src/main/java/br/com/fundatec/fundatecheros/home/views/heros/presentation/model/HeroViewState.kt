package br.com.fundatec.fundatecheros.home.views.heros.presentation.model

import br.com.fundatec.fundatecheros.home.views.profile.model.ProfileViewState

sealed class HeroViewState {

    object ShowNameError: HeroViewState()
    object ShowDescriptionError: HeroViewState()
    object ShowImageError: HeroViewState()
    object ShowUniverseTypeError: HeroViewState()
    object ShowCharacterTypeError: HeroViewState()
    object ShowAgeError: HeroViewState()
    object ShowBirthdayError: HeroViewState()
    object ShowHomeScreen: HeroViewState()

    object ShowGenericError: HeroViewState()

    object Loading : HeroViewState()


}
