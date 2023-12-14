package br.com.fundatec.fundatecheros.home.views.home.presentation.model

import br.com.fundatec.fundatecheros.home.views.home.domain.HeroModel

sealed class HomeViewState {
    data class Sucess(val list: List<HeroModel>) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()

}