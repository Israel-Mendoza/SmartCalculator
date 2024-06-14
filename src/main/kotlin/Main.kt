package dev.artisra

import dev.artisra.calculator.CalculatorImpl
import dev.artisra.utils.*

fun main() {
    val calculator = CalculatorImpl()
    ongoingCalculationPrompt(calculator)
}

//fun main() {
//    val expression = "-2 + 4 - 5 + 6"
//    val newExpression = expression.cleanMathExpression()
//    val result = getNumbersToAdd(newExpression)
//    println(result)
//}
//
