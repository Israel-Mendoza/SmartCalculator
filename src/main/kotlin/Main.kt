package dev.artisra

fun main() {
    val calculator = CalculatorImpl()
    ongoingCalculationPrompt(calculator, "/exit")
    println("Bye!")
}

fun ongoingCalculationPrompt(calculator: Calculator, safeWord: String) {
    while (true) {
        val input = readlnOrNull()
        if (input.equals(safeWord, ignoreCase = true)) break
        if (input.isNullOrEmpty()) continue
        val numbers = input.split(" ").map { it.toInt() }
        val result = if (numbers.size > 1) {
            calculator.add(numbers.first(), numbers.last())
        } else {
            calculator.add(numbers.first(), 0)
        }
        println(result)
    }
}