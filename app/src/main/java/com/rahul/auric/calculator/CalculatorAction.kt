package com.rahul.auric.calculator

sealed class CalculatorAction {
    data class Number(val value: String) : CalculatorAction()
    data class Operation(val symbol: String) : CalculatorAction()
    data object Clear : CalculatorAction()
    data object Backspace : CalculatorAction()
    data object Decimal : CalculatorAction()
    data object Calculate : CalculatorAction()
    data object Parentheses : CalculatorAction()

    data object Negate : CalculatorAction()
}