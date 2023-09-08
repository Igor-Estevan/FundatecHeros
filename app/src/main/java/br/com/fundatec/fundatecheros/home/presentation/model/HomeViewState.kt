package br.com.fundatec.fundatecheros.home.presentation.model

sealed class HomeViewState {
    data class Sucess(val message: String) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
    object hideButton : HomeViewState()
}