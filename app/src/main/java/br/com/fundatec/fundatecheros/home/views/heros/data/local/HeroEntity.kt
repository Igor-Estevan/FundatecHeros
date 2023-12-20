package br.com.fundatec.fundatecheros.home.views.heros.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class HeroEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: Int
)