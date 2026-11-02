package br.com.devmobileaj.imcfacil20.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.devmobileaj.imcfacil20.R
import br.com.devmobileaj.imcfacil20.domain.Imc


@Composable
fun ItemImc(item: Imc, onClick: (Imc) -> Unit){

    Card(
        modifier = Modifier.fillMaxWidth().height(80.dp).padding(top = 16.dp),
        elevation = CardDefaults.cardElevation(
              defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {

            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {

                val (icon, textoImc, botao) = createRefs()

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_calcule),
                    contentDescription = "Logo",
                    modifier = Modifier.padding(10.dp).constrainAs(icon){
                        top.linkTo(parent.top, margin = 8.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    }
                )

                Text(
                    text = "Imc : ${item.imcRes}",
                    modifier = Modifier.constrainAs(textoImc){
                        top.linkTo(parent.top, margin = 24.dp)
                        start.linkTo(icon.end, margin = 16.dp)
                    },
                )

                IconButton(
                    onClick = {
                         onClick(item)
                    },
                    modifier = Modifier.constrainAs(botao){
                        top.linkTo(parent.top, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_delete),
                        contentDescription = "botão de delete"
                    )
                }

            }


    }

}


@Composable
@Preview(showBackground = true)
fun ItemImcPreview(){
     val imc = Imc( 20.0)
     ItemImc( imc){}
}
