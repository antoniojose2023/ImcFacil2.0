package br.com.devmobileaj.imcfacil20.ui.telas

import android.widget.Toast
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.devmobileaj.imcfacil20.domain.Imc
import br.com.devmobileaj.imcfacil20.ui.Screen
import br.com.devmobileaj.imcfacil20.ui.components.Header
import br.com.devmobileaj.imcfacil20.ui.components.ItemImc

@Composable
fun HistoricoImc(navController: NavController){

    val context = LocalContext.current

    val scrollState = rememberNestedScrollInteropConnection()

    val imcs = listOf(
        Imc(20.0),
        Imc(50.0),
        Imc(40.0),
        Imc(30.0),
        Imc(35.0),
        Imc(35.0),
        Imc(35.0),
        Imc(35.0),
        Imc(35.0),
    )

    Column(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollState)
             .padding()
    ) {

        Header("Navegue pelo histórico de IMC")

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Registro Recentes",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 40.dp, end = 40.dp)
            )

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 16.dp)
            ) {
                Text("Voltar")
            }

        }

        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 40.dp, end = 40.dp),
        )

        LazyColumn(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 40.dp, end = 40.dp),
        ) {
            items(imcs){ imc->
                ItemImc(imc){ imc ->
                    Toast.makeText(context,"${imc.imcRes}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}


