package com.rahul.auric.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.rahul.auric.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This makes the app truly full-screen, drawing behind the system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            CalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}