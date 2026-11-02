package br.com.devmobileaj.imcfacil20.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.com.devmobileaj.imcfacil20.ui.theme.ImcFacil20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcFacil20Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        SetupNavigation()
                }
            }
        }
    }
}

