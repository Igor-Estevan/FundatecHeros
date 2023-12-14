package br.com.fundatec.fundatecheros.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fundatec.fundatecheros.App
import br.com.fundatec.fundatecheros.database.converter.Converters
import br.com.fundatec.fundatecheros.home.views.login.data.local.UserDao
import br.com.fundatec.fundatecheros.home.views.login.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class FHDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}