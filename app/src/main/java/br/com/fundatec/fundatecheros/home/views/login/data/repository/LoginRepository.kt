package br.com.fundatec.fundatecheros.home.views.login.data.repository

import android.util.Log
import br.com.fundatec.fundatecheros.home.views.login.data.LoginRequest
import br.com.fundatec.fundatecheros.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(LoginService::class.java)

    suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                Log.e("createUser","name $name")
                Log.e("createUser","email $email")
                Log.e("createUser","password $password")
                val response = repository.createUser(
                    loginRequest = LoginRequest(
                        name = name,
                        email = email,
                        password = password,
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                Log.e("createUser", ex.message.toString())
                false
            }
        }
    }

}