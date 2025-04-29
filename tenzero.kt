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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random



@Composable
@Preview
fun ThreeZadachi() {
    var Latters by remember { mutableStateOf("") }
    var textResult by remember { mutableStateOf("") }
    var StrokaOne by remember { mutableStateOf("") }
    var StrokaTwo by remember { mutableStateOf("") }
    var AbsolutStroka by remember { mutableStateOf("") }
    var Inverted by remember { mutableStateOf("") }

    val absolutStroka = remember(StrokaOne, StrokaTwo) { "$StrokaOne $StrokaTwo" }
    val inverted = remember(absolutStroka) { absolutStroka.reversed() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Ваш выбор: $textResult")



        Text(text = AbsolutStroka, modifier = Modifier.padding(vertical = 16.dp))
        Text(text = Inverted, modifier = Modifier.padding(vertical = 16.dp))
        TextField(value = Latters,
            onValueChange = {newText -> Latters = newText
                if (newText.isNotEmpty()) {
                    val char = newText.last() 
                    textResult = when {
                        !char.isUpperCase() || !char.isLetter() ->
                            "Ошибка: введите заглавную латинскую букву"
                        char in listOf('L', 'M', 'K', 'D') ->
                            "Это согласные буквы"
                        else ->
                            "Возможно, это гласные буквы"
                    }
                } else {
                    textResult = "Введите заглавную латинскую букву"
                }})
        TextField(value = StrokaOne,
            onValueChange = {newText -> StrokaOne = newText})
        TextField(value = StrokaTwo,
            onValueChange = {newText -> StrokaTwo = newText})


    }
}




