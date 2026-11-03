package br.com.devmobileaj.imcfacil20.ui.telas

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.devmobileaj.imcfacil20.data.entity.Imc
import br.com.devmobileaj.imcfacil20.data.repository.ImcRepository
import br.com.devmobileaj.imcfacil20.ui.components.Header
import br.com.devmobileaj.imcfacil20.ui.components.ItemImc
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun HistoricoImc(navController: NavController){

    val context = LocalContext.current

    var imcs by remember { mutableStateOf(emptyList<Imc>()) }

    val imcRepository = ImcRepository(context)

    val scrollState = rememberNestedScrollInteropConnection()

    LaunchedEffect(Unit){
        CoroutineScope(Dispatchers.IO).launch {
            imcs = imcRepository.getImcs()

            withContext(Dispatchers.Main){
                if(imcs.isEmpty()){
                    Toast.makeText(context, "Nenhum registro encontrado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollState)
    ) {

        Header("Navegue pelo histórico de IMC")

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Registros Recentes",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 40.dp, end = 40.dp)
            )

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, end = 24.dp)
            ) {
                Text("Voltar")
            }

        }

        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 40.dp, end = 40.dp),
        )

        LazyColumn(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp, start = 40.dp, end = 40.dp),
        ) {
            items(imcs){ imc->
                ItemImc(imc){ imc ->
                    CoroutineScope(Dispatchers.IO).launch {
                       val id = imcRepository.delete(imc)

                        withContext(Dispatchers.Main){
                            if(id > 0){
                                Toast.makeText(context, "Registro deletado com sucesso", Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(context, "Erro ao deletar o registro", Toast.LENGTH_SHORT).show()
                            }
                        }
                        imcs = imcRepository.getImcs()
                    }

                }
            }
        }

    }
}







