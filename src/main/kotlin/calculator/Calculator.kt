package dev.artisra.calculator

interface Calculator {
    fun addNumbers(numbers: List<Int>): Int
    fun add(a: Int, b: Int): Int
    fun subtract(a: Int, b: Int): Int
}