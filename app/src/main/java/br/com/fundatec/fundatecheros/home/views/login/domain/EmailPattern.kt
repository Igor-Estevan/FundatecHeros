package br.com.fundatec.fundatecheros.home.views.login.domain

fun String.isValidEmail(): Boolean {
    return contains("@") && contains("com")
}