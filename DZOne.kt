package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task3()
        }
    }
}
@Preview
@Composable
/*
fun Test() {
    val context = LocalContext.current
    var inputString by remember { mutableStateOf("")}
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Text("вариант 6")
                TextField(
                    value = inputString,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Настройка клавиатуры на ввод только чисел
                    onValueChange = { newText ->
                        if (newText.length <= 1) {
                            inputString = newText
                            Log.d("test", inputString);

                            if (inputString != "") {
                                val toast = Toast.makeText(
                                    context,
                                    getDayOfTheWeek(inputString),
                                    LENGTH_SHORT
                                ) //Создание текста Toast
                                toast.show() //Отображение Toast
                            }
                        }
                    }
                )
            }

        }

    }
*/
fun Task3() {
        val context = LocalContext.current //Контекст, используется для Toast (всплывающе окна)
        var a by remember { mutableStateOf("") } //Умная переменная
        var result1 by remember { mutableStateOf("") }

        Scaffold(modifier = Modifier.fillMaxSize()) {  innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("dz")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "ОТВЕТ= $result1"
                )


                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = a,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Настройка клавиатуры на ввод только чисел
                    onValueChange = {
                            newText ->
                        a = newText
                    }
                )

                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    result1 = makeFormula1(a)
                }) { Text("Рассчитать") }
            }

        }
    }


/*fun getDayOfTheWeek(dayNumber: String): String {
    return when (dayNumber){
        "1" -> "winter"
        "2" -> "spring"
        "3" -> "summer"
        "4" -> "autumn"
        else -> "Ошибка"
    }
}
 */
fun onetonine(num: Int): String {
   if (num >= 0 && num <= 9 )
   {
       return "Это цифра!"
   };
    else
       return "Непредусмотренный вариант!"
}

fun makeFormula1(a: String ): String{
    val int_a = a.toIntOrNull()?: 0
    if (int_a != 0)
        return onetonine(int_a) ;
    return when (a){
        "&" -> "«Это спец символ!»"
        "#" -> "«Это спец символ!»"
        "<" -> "«Это спец символ!»"
        "0" -> "«Это цифра!»"
        else -> "Непредусмотренный вариант!"
    }

}

