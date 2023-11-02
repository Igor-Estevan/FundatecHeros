package br.com.fundatec.fundatecheros.home.views.login.data.repository

import br.com.fundatec.fundatecheros.home.views.login.data.LoginRequest
import br.com.fundatec.fundatecheros.home.views.login.data.remote.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/api/login")
    suspend fun createUser(@Body loginRequest: LoginRequest,):Response<LoginResponse>

}