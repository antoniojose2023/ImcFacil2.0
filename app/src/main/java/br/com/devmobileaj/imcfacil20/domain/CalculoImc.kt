package br.com.devmobileaj.imcfacil20.domain

import android.annotation.SuppressLint
import java.util.Locale

class CalculoImc {

    companion object{

//            fun calcularImc(peso: Double, altura: Double): Double {
//                val imc = peso / (altura * altura)
//                return String.format(Locale.forLanguageTag("pt-BR"),"%.2f", imc).toDouble()
//            }

            fun configImc(imc: Double): String {
                return String.format(Locale.forLanguageTag("pt-BR"),"%.2f", imc)
            }

            fun classificarImc(imc: Double): String {
                return if(imc < 18.5){
                   "Abaixo do peso"
                }else if((imc >= 18.5) && (imc <= 24.9)){
                   "Peso normal"
                }else if((imc >= 25.0) && (imc <= 29.9)){
                     "Sobrepeso"
                }else if((imc >= 30.0) && (imc <= 34.9)){
                     "Obesidade Grau I"
                }else if((imc>= 35.0) && (imc <= 39.9)){
                     "Obesidade Grau II"
                }else {
                   "Obesidade Grau III"
                }
            }

           fun classificarImcDica(classificaco: String): String {
               return when(classificaco){
                   "Abaixo do peso" -> "Seu IMC está abaixo da faixa considerada saudável. Pode ser interessante conversar com um médico ou nutricionista para avaliar se sua alimentação está fornecendo os nutrientes necessários."
                   "Peso normal" -> "Seu IMC está dentro da faixa considerada saudável pela Organização Mundial da Saúde. Continue mantendo hábitos equilibrados de alimentação e atividade física."
                   "Sobrepeso" -> "Seu IMC está um pouco acima da faixa considerada ideal. Pequenos ajustes na alimentação e na rotina de exercícios podem ajudar a trazer esse número para a faixa saudável."
                   "Obesidade Grau I" -> "Seu IMC indica obesidade grau I. É recomendável buscar orientação médica ou nutricional para montar um plano de cuidados com sua saúde."
                   "Obesidade Grau II" -> "Seu IMC indica obesidade grau II, associada a maior risco de complicações de saúde. O acompanhamento com um profissional de saúde é importante para orientar os próximos passos."
                   "Obesidade Grau III" -> "Seu IMC indica obesidade grau III, um grau que exige atenção médica mais próxima. Buscar acompanhamento especializado é fundamental para cuidar da sua saúde."
                    else -> "Nenhuma classificação"
               }
           }

    }
}