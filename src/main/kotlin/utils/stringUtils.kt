package dev.artisra.utils

fun String.cleanMathExpression(): String {
    return this
        .cleanPlusSignsInMathExpr()
        .cleanMinusSignsInMathExpr()
        .cleanExtraSpaces()
}

fun String.cleanPlusSignsInMathExpr(): String {
    val pattern = "\\+{2,}".toRegex()
    return this.replace(pattern, "+")
}

fun String.cleanMinusSignsInMathExpr(): String {
    val pattern = "-{2,}".toRegex()
    val allMatches = pattern.findAll(this).map { it.value }.toList()
    var result = this
    allMatches.forEach {
        result = result.replace(it, cleanMinusSigns(it))
    }
    return result
}

fun String.cleanExtraSpaces(): String {
    val pattern = "\\s{2,}".toRegex()
    return this.replace(pattern, " ")
}

fun cleanMinusSigns(minusSigns: String): String = if (minusSigns.length % 2 == 0) "+" else "-"
