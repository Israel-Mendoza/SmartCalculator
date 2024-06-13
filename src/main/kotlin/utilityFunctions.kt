package dev.artisra

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
            val numbers = input.split(" ").map { it.toInt() }
            val result = calculator.add(numbers)
            println(result)
            true
        }
    }


fun printHelpMessage() {
    val message = "The program calculates the sum of numbers"
    println(message)
}