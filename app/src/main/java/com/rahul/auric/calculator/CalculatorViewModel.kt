package com.rahul.auric.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.mariuszgromada.math.mxparser.Expression

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorState())
    val uiState: StateFlow<CalculatorState> = _uiState.asStateFlow()

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> append(action.value)
            is CalculatorAction.Operation -> append(action.symbol)
            is CalculatorAction.Decimal -> append(".")
            is CalculatorAction.Parentheses -> handleParentheses()
            is CalculatorAction.Clear -> _uiState.value = CalculatorState()
            is CalculatorAction.Backspace -> performBackspace()
            is CalculatorAction.Calculate -> performCalculation()
            // NEW: This is the line that fixes the error
            is CalculatorAction.Negate -> performNegation()
        }
    }

    // NEW: This is the function that provides the logic for Negate
    private fun performNegation() {
        val expression = _uiState.value.expression
        if (expression.isBlank()) return

        // Find where the last number starts
        val lastOperatorIndex = expression.findLastAnyOf(listOf("+", "-", "*", "/", "%", "("))?.first ?: -1
        val lastNumberString = expression.substring(lastOperatorIndex + 1)

        if (lastNumberString.isBlank()) return // Nothing to negate

        // The expression before the last number
        val baseExpression = expression.substring(0, lastOperatorIndex + 1)

        val newExpression = if (lastNumberString.startsWith("(-") && lastNumberString.endsWith(")")) {
            // It's already negated, so un-negate it by removing the wrapper
            val unNegatedNumber = lastNumberString.removeSurrounding("(-", ")")
            baseExpression + unNegatedNumber
        } else {
            // It's a positive number, so negate it by wrapping it
            baseExpression + "(-${lastNumberString})"
        }

        _uiState.update { it.copy(expression = newExpression) }
        calculateLiveResult()
    }


    private fun append(str: String) {
        _uiState.update { it.copy(expression = it.expression + str) }
        calculateLiveResult()
    }

    private fun handleParentheses() {
        val expression = _uiState.value.expression
        val openParenCount = expression.count { it == '(' }
        val closedParenCount = expression.count { it == ')' }

        if (openParenCount > closedParenCount && expression.lastOrNull()?.isDigit() == true) {
            append(")")
        } else {
            append("(")
        }
    }

    private fun performBackspace() {
        if (_uiState.value.expression.isNotBlank()) {
            _uiState.update { it.copy(expression = it.expression.dropLast(1)) }
            calculateLiveResult()
        }
    }

    private fun performCalculation() {
        val result = _uiState.value.result
        if (result.isNotBlank()) {
            _uiState.value = CalculatorState(expression = result)
        }
    }

    private fun calculateLiveResult() {
        val expressionString = _uiState.value.expression
        if (expressionString.isBlank()) {
            _uiState.update { it.copy(result = "") }
            return
        }
        try {
            val expression = Expression(expressionString)
            val result = expression.calculate()

            if (!result.isNaN()) {
                _uiState.update { it.copy(result = formatResult(result)) }
            }
        } catch (e: Exception) {
            _uiState.update { it.copy(result = "") }
        }
    }

    private fun formatResult(result: Double): String {
        return if (result % 1.0 == 0.0) {
            result.toLong().toString()
        } else {
            result.toString()
        }
    }
}