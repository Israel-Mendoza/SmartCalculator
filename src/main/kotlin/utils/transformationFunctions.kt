package dev.artisra.utils

fun getNumbersToAdd(mathExpr: String): List<Int> {
    return mathExpr
        .replace("- ", "-")
        .replace("--", "+")
        .filterNot { it == '+' }
        .split(" ")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
}