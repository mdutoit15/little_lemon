package com.example.littlelemon_final

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.littlelemon_final.ui.theme.LittleLemonFinalTheme

class MainActivity : ComponentActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences("Little Lemon", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonFinalTheme {
                App(sharedPreferences)
            }
        }
    }
}

@Composable
fun App(sharedPreferences: SharedPreferences) {
    Column {
        Navigation(sharedPreferences)
    }
}