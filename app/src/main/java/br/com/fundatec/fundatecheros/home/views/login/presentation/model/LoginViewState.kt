package br.com.fundatec.fundatecheros.home.views.login.presentation.model

import br.com.fundatec.fundatecheros.home.presentation.model.HomeViewState

sealed class LoginViewState {

    data class Success(val message: String) : LoginViewState()
    object Loading : LoginViewState()
    data class Error(val errorMessage: String) : LoginViewState()
    object ShowEmailError : LoginViewState()
    object ShowPasswordError : LoginViewState()

}