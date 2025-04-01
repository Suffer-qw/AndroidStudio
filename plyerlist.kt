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
import com.example.top_academy_lab1.ui.theme.weeks.Task
import kotlin.random.Random

data class Cplayer(
    val Name: String,
    val Choice: Int,
)

@Composable
fun hahaha() {
    var playerChoice by remember { mutableStateOf("") }
    var playerName by remember { mutableStateOf("") }
    val showList = remember { mutableStateOf(false) }
    val playerListLazy by remember { mutableStateOf(mutableListOf(
        Cplayer("Fore", 4),
        Cplayer("two", 2),
        Cplayer("twotwo", 22),
        Cplayer("Zoro", 1),
        Cplayer("ten", 10),
    )) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "${playerListLazy.size}")
        Text(text = "$playerName")
        Text(text = "$playerChoice")
        TextField(
            value = playerName,
            onValueChange = {newText -> playerName = newText}
        )
        TextField(
            value = playerChoice,
            onValueChange = {newText -> playerChoice = newText},
            modifier = Modifier.padding(10.dp)
        )


            Button(
                onClick = { playerListLazy.add(Cplayer(playerName,playerChoice.toInt()))
                    playerName = ""
                    playerChoice = ""},
                modifier = Modifier.padding(20.dp)
            ) {
                Text(text = "добавить")
            }

        Button(
            onClick = {showList.value = !showList.value },
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "вывод")
        }

        if (showList.value) {
            Plaerlist(playerListLazy)
        }

    }
}



@Composable
fun Plaerlist( playerListLazy: List<Cplayer>) {
    val sortedList = playerListLazy.sortedBy({it.Choice})


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        sortedList.forEach { text ->
            Text(text = "${text.Name}  ${text.Choice}", modifier = Modifier.padding(4.dp))
        }

    }
}
