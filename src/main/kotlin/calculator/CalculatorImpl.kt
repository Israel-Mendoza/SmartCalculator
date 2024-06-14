package dev.artisra.calculator

class CalculatorImpl : Calculator {
    override fun addNumbers(numbers: List<Int>): Int = numbers.sum()
    override fun add(a: Int, b: Int): Int = a + b
    override fun subtract(a: Int, b: Int): Int = a - b
}