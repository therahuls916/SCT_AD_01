package com.rahul.auric.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rahul.auric.calculator.ui.theme.*

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val buttonSpacing = 12.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            // --- DISPLAY ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = state.expression,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Light,
                    fontSize = 48.sp,
                    color = White,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = state.result,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp,
                    color = White,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            // --- NEW ROW: DEDICATED BACKSPACE BUTTON ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                CalculatorButton(
                    symbol = "⌫",
                    backgroundColor = Black, // Blends in with the background
                    textColor = TextGreen,
                    onClick = { viewModel.onAction(CalculatorAction.Backspace) }
                )
            }


            // --- BUTTON PAD ---
            Column(verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(symbol = "C", backgroundColor = DarkGray, textColor = TextRed, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Clear) })
                    CalculatorButton(symbol = "()", backgroundColor = DarkGray, textColor = TextGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Parentheses) })
                    CalculatorButton(symbol = "%", backgroundColor = DarkGray, textColor = TextGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation("%")) })
                    // RESTORED THE DIVIDE BUTTON HERE
                    CalculatorButton(symbol = "÷", backgroundColor = DarkGray, textColor = TextGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation("/")) })
                }
                // --- ROW 2 ---
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(symbol = "7", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("7")) })
                    CalculatorButton(symbol = "8", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("8")) })
                    CalculatorButton(symbol = "9", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("9")) })
                    CalculatorButton(symbol = "x", backgroundColor = DarkGray, textColor = TextGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation("*")) })
                }
                // --- ROW 3 ---
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(symbol = "4", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("4")) })
                    CalculatorButton(symbol = "5", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("5")) })
                    CalculatorButton(symbol = "6", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("6")) })
                    CalculatorButton(symbol = "-", backgroundColor = DarkGray, textColor = TextGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation("-")) })
                }
                // --- ROW 4 ---
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(symbol = "1", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("1")) })
                    CalculatorButton(symbol = "2", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("2")) })
                    CalculatorButton(symbol = "3", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("3")) })
                    CalculatorButton(symbol = "＋", backgroundColor = DarkGray, textColor = TextGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation("+")) })
                }
                // --- ROW 5 ---
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(symbol = "+/-", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Negate) })
                    CalculatorButton(symbol = "0", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number("0")) })
                    CalculatorButton(symbol = ".", backgroundColor = DarkGray, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Decimal) })
                    CalculatorButton(symbol = "=", backgroundColor = ButtonGreen, modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { viewModel.onAction(CalculatorAction.Calculate) })
                }
            }
        }
    }
}