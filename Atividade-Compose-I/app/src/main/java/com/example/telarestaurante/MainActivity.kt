package com.example.telarestaurante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.telarestaurante.ui.theme.TelaRestauranteTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaRestauranteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaRestaurante(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaRestaurante(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(16.dp))
        CabecalhoRestaurante()
        Spacer(modifier = Modifier.height(16.dp))
        InfoRestaurante()
        Spacer(modifier = Modifier.height(16.dp))
        PratoDoDia()
        Spacer(modifier = Modifier.height(16.dp))
        SeletorQuantidade()
        Spacer(modifier = Modifier.height(16.dp))
        BotaoFazerPedido()
    }
}
@Composable
fun CabecalhoRestaurante(){
    Column{
        Text(text = "SABOR DO SERTÃO", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Comida regional")
    }
}

@Composable
fun InfoRestaurante(){
    Column {
        Text(text = "★ Avaliação: 4.8")
        Text(text = "Tempo: 30-40 min")
    }
}

@Composable
fun PratoDoDia(){
    Column {
        Text(text = "Prato do dia: Baião", fontWeight = FontWeight.Bold)
        Text(text = "R$ 24,90")
    }
}


@Preview(showBackground = true)
@Composable
fun TelaRestaurantePreview() {
    TelaRestauranteTheme {
        TelaRestaurante()
    }
}

@Composable
fun SeletorQuantidade() {
    var quantidade by remember { mutableStateOf(1) }

    Row(verticalAlignment = Alignment.CenterVertically) {

        Button(onClick = { if (quantidade > 1) quantidade-- }) {
            Text("-")
        }

        Text(
            text = "Quantidade: $quantidade",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Button(onClick = { quantidade++ }) {
            Text("+")
        }
    }
}

@Composable
fun BotaoFazerPedido(){
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("FAZER PEDIDO")
    }
}