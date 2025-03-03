package com.example.calculator.Modules

class Calculator(private val number1: Double, private val number2: Double) {
    fun add() = number1 + number2
    fun subtract() = number1 - number2
    fun multiply() = number1 * number2
    fun divide() = if (number2 != 0.0) number1 / number2 else Double.NaN // Handle division by zero
}