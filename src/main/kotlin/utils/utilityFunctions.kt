package dev.artisra.utils

import dev.artisra.calculator.Calculator

fun ongoingCalculationPrompt(calculator: Calculator) {
    var keepProgramAlive = true
    while (keepProgramAlive) {
        val input = readlnOrNull()
        keepProgramAlive = dispatchAction(input, calculator)
    }
}

fun dispatchAction(input: String?, calculator: Calculator): Boolean = when {
        input.isNullOrEmpty() -> true
        input.equals("/exit", ignoreCase = true) -> {
            println("Bye!")
            false
        }
        input.equals("/help", ignoreCase = true) -> {
            printHelpMessage()
            true
        }
        else -> {
            val numbers = getNumbersToAdd(input.cleanMathExpression())
            val result = calculator.addNumbers(numbers)
            println(result)
            true
        }
    }


fun printHelpMessage() {
    val message = "The program calculates the sum and subtraction of numbers."
    println(message)
}

fun expressionBreaker(expression: String): List<Int> {
    val items = expression.split("\\s".toRegex()).filterNot { it.isBlank() || it.isEmpty() }

    return listOf()
}