package br.com.devmobileaj.imcfacil20.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tb_imc")
data class Imc(
     @PrimaryKey(autoGenerate = true)
     val id: Long = 0L,
     val imc: Double
)
