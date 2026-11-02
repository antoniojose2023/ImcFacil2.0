package br.com.devmobileaj.imcfacil20.ui

import android.R
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.devmobileaj.imcfacil20.ui.telas.CalculoImc
import br.com.devmobileaj.imcfacil20.ui.telas.HistoricoImc
import br.com.devmobileaj.imcfacil20.ui.telas.ResultadoIMC
import br.com.devmobileaj.imcfacil20.ui.telas.SplashScreen

@Composable
fun SetupNavigation(){

     val navController = rememberNavController()

     NavHost(
          navController = navController,
          startDestination = Screen.SPLASHSCREEN,
     ){
          composable(route = Screen.SPLASHSCREEN) {
               SplashScreen(navController)
          }
          composable(route = Screen.CALCULO) {
               CalculoImc(navController)
          }
          composable(route = Screen.RESULTADO + "/{${Screen.IMC}}", arguments = listOf(
                    navArgument(Screen.IMC){
                      type = NavType.FloatType
                      defaultValue = 0.0F
                      nullable = false
                    }
                )
          ) {
               ResultadoIMC(navController, imc = it.arguments?.getFloat(Screen.IMC)?.toDouble() ?: 0.0)
          }
          composable(route = Screen.HISTORICO) {
               HistoricoImc(navController)
          }
     }

}