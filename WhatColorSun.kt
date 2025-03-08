package com.example.myapplication.ui.theme.progect
import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun QuizApp() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val hard = listOf(
            Question(
                "Чему равно число π (пи) с точностью до 5 знаков после запятой?",
                listOf("3.14159", "3.14285", "3.14125"),
                "3.14159"
            ),
            Question(
                "Какой элемент имеет самую высокую температуру плавления?",
                listOf("Вольфрам", "Углерод", "Осмий"),
                "Вольфрам"
            ),
            Question(
                "Чему равно значение предела lim(x → 0) (sin(x)/x)?",
                listOf("0", "1", "∞"),
                "1"
            ),
            Question(
                "Какой газ является самым легким?",
                listOf("Водород", "Гелий", "Азот"),
                "Водород"
            ),
            Question(
                "Какая из этих кислот является самой сильной?",
                listOf("Серная кислота", "Соляная кислота", "Плавиковая кислота"),
                "Серная кислота"
            ),
            Question(
                "Чему равно значение интеграла ∫(от 0 до 1) x^2 dx?",
                listOf("1/2", "1/3", "1/4"),
                "1/3"
            )
        )
        val normal = listOf(
            Question("Какая страна самая крупная?", listOf("Китай", "Россия", "США"), "Россия"),
            Question("Какой сейчас год?", listOf("2025", "2000", "2008"), "2025"),
            Question(
                "Какая медаль за первое место?",
                listOf("Бронзовая", "Серебряная", "Золотая"),
                "Золотая"
            )
        )
        val easy = listOf(
            Question(
                "Какого цвета солнышко?",
                listOf("Желтое", "Синее", "Зеленое"),
                "Желтое"
            ),
            Question(
                "Какое животное говорит 'мяу'?",
                listOf("Собака", "Кошка", "Корова"),
                "Кошка"
            ),
            Question(
                "Сколько лап у собаки?",
                listOf("2", "4", "6"),
                "4"
            )
        )


        var chek by remember { mutableStateOf(false) }
        var quuestions:List<Question> by remember { mutableStateOf(emptyList()) }
        if (chek && quuestions.isNotEmpty()) {
            QuizStart(quuestions)
        }
        else {
            Button(onClick = {
                quuestions = hard
                chek = true

            }) {
                Text(text = "hard")
            }

            Button(onClick = {
                quuestions = normal
                chek = true

            }) {
                Text(text = "normal")
            }

            Button(onClick = {
                quuestions = easy
                chek = true

            }) {
                Text(text = "hard2")
            }
        }

    }

    }





    @Composable
    fun QuizStart(questions: List<Question>) {
        var restart by remember { mutableStateOf(false) }
        var currentQuestion by remember { mutableIntStateOf(0) }
        var selectedAnswer by remember { mutableStateOf("") }
        var score by remember { mutableIntStateOf(0) }
        var quizFinished by remember { mutableStateOf(false) }
        var enabledButton by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!quizFinished) {
                Text(text = "Вопрос: ${questions[currentQuestion].text}")
                Spacer(modifier = Modifier.height(12.dp))

                questions[currentQuestion].options.forEach { option ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedAnswer == option,
                            onClick = {
                                selectedAnswer = option
                                questions[currentQuestion].options.forEach { option ->
                                    if (selectedAnswer == option)
                                        enabledButton = true
                                }
                            }
                        )
                        Text(text = option)
                    }
                }


                Button(onClick = {
                    if (selectedAnswer == questions[currentQuestion].correctAnswer) {
                        score++
                    }
                    if (currentQuestion < questions.size - 1)
                        currentQuestion++
                    else
                        quizFinished = true
                    selectedAnswer = ""
                    enabledButton = false
                }, enabled = enabledButton) {
                    Text(text = if (currentQuestion < questions.size - 1) "Следующий вопрос" else "Закончить")
                }
            } else {
                Text(text = "Ваш результат: $score/${questions.size}")
                Button(onClick = {
                    restart = true
                    quizFinished = false
                    currentQuestion = 0
                    score = 0
                    selectedAnswer = ""
                }) {
                    Text(text = "Перезапустить квиз")
                }
            }
            if (restart)
                QuizApp()
        }
    }



data class Question(val text: String, val options: List<String>, val correctAnswer: String)
