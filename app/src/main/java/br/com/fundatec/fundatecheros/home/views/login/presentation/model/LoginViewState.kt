package br.com.fundatec.fundatecheros.home.views.login.presentation.model

import br.com.fundatec.fundatecheros.home.views.home.presentation.model.HomeViewState

sealed class LoginViewState {

    object Loading : LoginViewState()
    object ShowErrorMessage : LoginViewState()
    object ShowHomeScreen : LoginViewState()
    object ShowEmailError : LoginViewState()
    object ShowPasswordError : LoginViewState()

}