package br.com.fundatec.fundatecheros.home.views.profile.model

sealed class ProfileViewState {
    object Success : ProfileViewState()
    object Loading : ProfileViewState()
    object Error : ProfileViewState()
    object ShowNameError : ProfileViewState()
    object ShowEmailError : ProfileViewState()
    object ShowPasswordError : ProfileViewState()
}