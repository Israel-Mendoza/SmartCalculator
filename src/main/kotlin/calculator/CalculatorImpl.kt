package dev.artisra.calculator

class CalculatorImpl : Calculator {
    private val message = "The program calculates the sum and subtraction of numbers."
    override fun add(a: Int, b: Int): Int = a + b
    override fun subtract(a: Int, b: Int): Int = a - b
    override fun calculate(a: Int, op: Char, b: Int): Int {
        return when (op) {
            '+' -> add(a, b)
            '-' -> subtract(a, b)
            else -> throw IllegalArgumentException("Invalid operator: $op")
        }
    }
    override fun process(tokens: Pair<List<Int>, List<Char>>): Int {
        val (numbers, operations) = tokens

        var currentValue = numbers.first()
        var currentOp = operations.first()

        for (i in operations.indices) {
            currentValue = calculate(currentValue, currentOp, numbers[i + 1])
            currentOp = operations.getOrNull(i + 1) ?: break
        }
        return currentValue
    }
    override fun printHelp() {
        println(message)
    }
}