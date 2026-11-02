package br.com.devmobileaj.imcfacil20.data.repository

import android.content.Context
import br.com.devmobileaj.imcfacil20.data.database.ImcDatabase
import br.com.devmobileaj.imcfacil20.data.entity.Imc

class ImcRepository(val context: Context) {
    private val imcDao = ImcDatabase.getInstance( context ).imcDao()

    suspend fun salvar(imc: Imc): Long{
         return imcDao.insert( imc )
    }

    suspend fun delete(imc: Imc): Int{
        return imcDao.delete( imc )
    }

    suspend fun getImcs(): List<Imc>{
        return imcDao.getImcs()
    }
}