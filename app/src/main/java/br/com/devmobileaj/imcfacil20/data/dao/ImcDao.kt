package br.com.devmobileaj.imcfacil20.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.devmobileaj.imcfacil20.data.entity.Imc

@Dao
interface ImcDao {
    @Insert
    suspend fun insert(imc: Imc): Long

    @Delete
    suspend fun delete(imc: Imc): Int

    @Query("SELECT * FROM tb_imc")
    suspend fun getImcs(): List<Imc>

}