package com.example.myapplication.ui.theme.progect
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Chislo() {
    var playerChoice by remember { mutableStateOf("") }
    var AiChislo by remember { mutableStateOf("") }
    var popitki by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf(Random.nextInt(0, 100).toString()) }


    fun determineWinner(player: Int, computer: Int): String {
        return when {
            player == computer -> "win"
            player > computer -> "больше"
            player < computer -> "меньше"
            else -> "error"
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "ваше число $playerChoice", fontSize = 28.sp)
        Text(text = "ваше число $AiChislo", fontSize = 24.sp)
        Text(text = "число попыток  $popitki")
        //Text(text = "загаданое  $result")

            Text(playerChoice, fontSize = 28.sp)
            TextField(
                value = playerChoice,
                onValueChange = {newText -> playerChoice = newText}
            )

        if (AiChislo == "win")
        {
            Button(
                onClick = {
                    result = Random.nextInt(0, 100).toString()
                    AiChislo = "ыыедите число "
                    popitki = 0
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "новая игра")
            }
        }
        else {
            Button(
                onClick = {
                    AiChislo = determineWinner(playerChoice.toInt(), result.toInt())
                    popitki++
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "chek")
            }
        }


    }
}
