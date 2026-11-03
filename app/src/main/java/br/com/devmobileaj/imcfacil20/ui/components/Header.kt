package br.com.devmobileaj.imcfacil20.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devmobileaj.imcfacil20.R
import br.com.devmobileaj.imcfacil20.ui.theme.Green

@Composable
fun Header(descricao: String){

    Column(
        modifier = Modifier.fillMaxWidth().height(240.dp)
            .background(Green, shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)),
    ) {

        Image(
            painter = painterResource(R.drawable.ic_logo),
            modifier = Modifier.padding(top = 80.dp, start = 24.dp).size(40.dp),
            contentDescription = "Logo",

        )

        Text(
             "Calcúlo Imc",
             fontSize = 18.sp,
             modifier = Modifier.padding(top = 16.dp, start = 24.dp),
             color = Color.White
        )

        Text(
            descricao,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp, start = 24.dp),
            color = Color.White
        )

    }

}