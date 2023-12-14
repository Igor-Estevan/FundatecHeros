package br.com.fundatec.fundatecheros.home.views.splash.presentation.model

sealed class SplashViewState {
    object ShowLogin : SplashViewState()
    object ShowHome : SplashViewState()
}