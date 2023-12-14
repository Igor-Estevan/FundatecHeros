package br.com.fundatec.fundatecheros.home.views.heros.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDao {

    @Insert
    fun insertHero(heroEntity: HeroEntity)

//    @Query("DELETE FROM character_table")
//    fun clearCache()

}