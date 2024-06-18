package dev.artisra.utils

fun String.parseArithmeticExpression(): Pair<List<Int>, List<Char>> {

    if (this.first() == '/') throw UnknownCommand()
    if (this.first() == '*') throw InvalidExpression()

    val validArithmeticOps = setOf('+', '-', '*', '/')
    val cleanedExpression = this.cleanMathExpression()

    if (cleanedExpression.last() in validArithmeticOps) {
        throw InvalidExpression()
    }

    // Placeholders:
    val numbers = mutableListOf<Int>()
    val operators = mutableListOf<Char>()

    var currentNumber = 0
    for (char in cleanedExpression) {
        when {
            char.isDigit() -> {
                val digit = char.digitToInt()
                val temp = currentNumber * 10
                currentNumber = temp + digit
            }
            char in validArithmeticOps || char == ' ' -> {
                numbers.add(currentNumber)
                currentNumber = 0
                operators.add(char)
            }
            else -> throw InvalidExpression()
        }
    }
    numbers.add(currentNumber)
    if (operators.isEmpty()) throw InvalidExpression()
    return Pair(numbers, operators)
}