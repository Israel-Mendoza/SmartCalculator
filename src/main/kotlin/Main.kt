package dev.artisra

import dev.artisra.calculator.CalculatorImpl
import dev.artisra.utils.*

fun main() {
    val calculator = CalculatorImpl()
    ongoingCalculationPrompt(calculator)
}
