package br.com.fundatec.fundatecheros.home.views.heros.data.repository

import br.com.fundatec.fundatecheros.home.views.heros.data.HeroRequest
import br.com.fundatec.fundatecheros.home.views.heros.data.remote.HeroResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HeroService {

    @POST("/api/character/{userId}")
    suspend fun createHero(
        @Path("userId") userId: Int,
        @Body heroRequest: HeroRequest
    ): Response<HeroResponse>

    @GET("/api/character/{userId}")
    suspend fun listHero(@Path("userId") userId: Int): Response<List<HeroResponse>>

}