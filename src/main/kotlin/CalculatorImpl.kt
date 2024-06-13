package dev.artisra

class CalculatorImpl : Calculator {
    override fun add(numbers: List<Int>): Int = numbers.sum()
}