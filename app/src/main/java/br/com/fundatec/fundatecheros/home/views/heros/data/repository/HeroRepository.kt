package br.com.fundatec.fundatecheros.home.views.heros.data.repository

import br.com.fundatec.fundatecheros.home.views.heros.data.HeroRequest
import br.com.fundatec.fundatecheros.home.views.heros.data.remote.HeroResponse
import br.com.fundatec.fundatecheros.home.views.login.data.repository.LoginRepository
import br.com.fundatec.fundatecheros.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(HeroService::class.java)

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    suspend fun createHero(
        name: String,
        description: String,
        image: String,
        characterType: String,
        age: Int,
        birthday: String?,
    ):Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createHero(
                    userId = loginRepository.getId(),
                    heroRequest = HeroRequest(
                        name = name,
                        description = description,
                        image = image,
                        characterType = characterType,
                        age = age,
                        birthday = null,
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                false
            }
        }
    }

    suspend fun listHero(): List<HeroResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.listHero(
                    userId = loginRepository.getId()
                )
                response.body()?: listOf()
            } catch (ex: Exception) {
                listOf();
            }
        }
    }


//    suspend fun clearDateCache() {
//        return withContext(Dispatchers.IO) {
//            database.heroDao().clearCache()
//        }
//    }

}