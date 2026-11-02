package br.com.devmobileaj.imcfacil20.ui.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.devmobileaj.imcfacil20.domain.CalculoImc
import br.com.devmobileaj.imcfacil20.ui.components.Header
import br.com.devmobileaj.imcfacil20.ui.theme.Green_50

@Composable
fun ResultadoIMC(navController: NavController, imc: Double){

    val imcFormatado = CalculoImc.configImc(imc = imc)
    val classificacao = CalculoImc.classificarImc(imc = imc)
    val classificacaoImcDica = CalculoImc.classificarImcDica( classificacao  )

    Column(
        modifier = Modifier.fillMaxSize()
            .padding()
    ) {

        Header("Verifique seus resultados")

        Spacer(modifier = Modifier.padding(16.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier.size(160.dp)
                    .background(Green_50, shape = CircleShape),
                Alignment.Center
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        imcFormatado,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        "imc/kg",
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }


            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp).height(60.dp).padding(top = 16.dp),

            ) {
                Text(
                    classificacao,
                    fontSize = 15.sp,
                    color = Color.White,
                )
            }


            Text(
                classificacaoImcDica,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.padding(top = 40.dp, start = 16.dp, end = 16.dp)
            )



        }


        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.width(200.dp).height(80.dp).padding(top = 32.dp),

                ) {
                Text(
                    "Voltar",
                    fontSize = 15.sp,
                    color = Color.White,
                )
            }
        }

    }
}