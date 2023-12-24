package br.com.fundatec.fundatecheros.home.views.heros.data.repository

import br.com.fundatec.fundatecheros.home.views.heros.data.HeroRequest
import br.com.fundatec.fundatecheros.home.views.heros.data.remote.HeroResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HeroService {

    @POST("/api/character/{userId}")
    suspend fun createHero(
        @Path("userId") userId: Int,
        @Body heroRequest: HeroRequest
    ): Response<ResponseBody>

    @GET("/api/character/{userId}")
    suspend fun listHero(@Path("userId") userId: Int): Response<List<HeroResponse>>

    @DELETE("/api/character/{idCharacter}")
    suspend fun removeHero(
        @Path("idCharacter") idCharacter: Int,
    ): Response<ResponseBody>

}