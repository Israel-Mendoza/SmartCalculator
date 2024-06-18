package dev.artisra.calculator

interface Calculator {
    fun add(a: Int, b: Int): Int
    fun subtract(a: Int, b: Int): Int
    fun calculate(a: Int, op: Char, b: Int): Int
    fun process(tokens: Pair<List<Int>, List<Char>>): Int
    fun printHelp()
}