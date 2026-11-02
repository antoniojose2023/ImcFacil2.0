package br.com.devmobileaj.imcfacil20.ui.telas

import android.annotation.SuppressLint
import android.content.Context

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import br.com.devmobileaj.imcfacil20.R
import br.com.devmobileaj.imcfacil20.ui.Screen
import br.com.devmobileaj.imcfacil20.ui.theme.Green
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


const val TAG = 2000L
@Composable
fun SplashScreen(navController: NavController){

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(TAG.milliseconds)
        navController.navigate(Screen.CALCULO)
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp),
            tint = Color.White
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            "Bem vindo ao IMC Facil",
             color = Color.White,
             fontSize = 25.sp
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            "Verifique de forma fácil seu indice de massa corporal e cuide de saúde",
             modifier = Modifier.padding(start = 16.dp, end = 16.dp),
             textAlign = TextAlign.Center,
             color = Color.White,
             fontSize = 18.sp
        )

        Spacer(modifier = Modifier.padding(16.dp))

        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 60.dp, end = 60.dp)
        )

    }

}


