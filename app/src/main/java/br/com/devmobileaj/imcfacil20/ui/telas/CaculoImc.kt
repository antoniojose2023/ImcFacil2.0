package br.com.devmobileaj.imcfacil20.ui.telas

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.devmobileaj.imcfacil20.R
import br.com.devmobileaj.imcfacil20.domain.Imc
import br.com.devmobileaj.imcfacil20.ui.Screen
import br.com.devmobileaj.imcfacil20.ui.components.Header
import br.com.devmobileaj.imcfacil20.ui.theme.Green
import br.com.devmobileaj.imcfacil20.ui.theme.Green_50
import br.com.devmobileaj.imcfacil20.ui.theme.Green_90

@Composable
fun CalculoImc(navController: NavController){

    val context = LocalContext.current
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding()
    ) {

        Header("Faça um cálculo de IMC")

        Spacer(modifier = Modifier.padding(16.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_calcule),
                contentDescription = "Logo",
                modifier = Modifier
                    .background(Green_90, shape = CircleShape)
                    .padding(16.dp)
                    .size(40.dp),
                tint = Color.Gray
            )

            Spacer(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

            OutlinedTextField(
                value = peso,
                onValueChange = { it ->
                    peso = it
                },
                //label = { Text("Peso") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                placeholder = {
                    Text("Peso em : 80kg")
                },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)
            )

            OutlinedTextField(
                value = altura,
                onValueChange = { it ->
                    altura = it
                },
              //  label = { Text("Altura") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                placeholder = {
                    Text("Altura em : 1.70m")
                },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 16.dp, end = 16.dp)
            )

            Spacer(modifier = Modifier.padding(16.dp))

            Button(
                onClick = {
                      val altura = altura.replace(",", ".").toDoubleOrNull()
                      val peso = peso.replace(",", ".").toDoubleOrNull()

                      if(altura != null && peso != null){
                           val res = peso / (altura * altura)
                           navController.navigate(Screen.RESULTADO + "/${res}")
                           //val imc = Imc(res)


                      }else{
                          Toast.makeText(context, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
                      }

                },
                modifier = Modifier.fillMaxWidth().height(60.dp).padding(start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                      containerColor = Green,
                      contentColor = Color.White
                )
            ) {
                Text(
                    "Calcular",
                    fontSize = 14.sp
                )
            }

           Spacer(modifier = Modifier.padding(4.dp))

            Button(
                onClick = {
                     navController.navigate(Screen.HISTORICO)
                },
                modifier = Modifier.fillMaxWidth().height(60.dp).padding(start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green_50,
                    contentColor = Color.White
                )
            ) {
                Text(
                    "Histórico",
                     fontSize = 14.sp
                )
            }

        }

    }

}