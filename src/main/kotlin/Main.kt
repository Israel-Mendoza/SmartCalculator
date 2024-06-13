package dev.artisra

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    println(numbers.first() + numbers.last())
}