package br.com.devmobileaj.imcfacil20.data.database

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.devmobileaj.imcfacil20.data.dao.ImcDao
import br.com.devmobileaj.imcfacil20.data.entity.Imc

@Database(
    entities = [Imc::class], version = 1
)
abstract class ImcDatabase: RoomDatabase() {

    abstract fun imcDao(): ImcDao
    companion object{
        @Volatile
        private var instance : ImcDatabase? = null

        fun getInstance(context: Context): ImcDatabase{
            return instance ?: synchronized(this){
                 instance ?: Room.databaseBuilder(
                     context.applicationContext,
                     ImcDatabase::class.java,
                     "imc.db"
                 ).build().also {
                     instance = it
                 }
            }

        }
    }
}