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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.top_academy_lab1.ui.theme.weeks.Task
import kotlin.random.Random


@Composable
fun sto() {
    val ListLazy = remember { mutableStateListOf<Int>()}

    var i = 100
    var x =0;
    while  ( i > 0)
    {
        if (i % 2 != 0) {
            x = i*i
            ListLazy.add(x)
        }
        i--;
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(ListLazy) { text ->
            ElevatedButton(
            onClick = {ListLazy.remove(text)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "$text")
        }
        }
    }
}
