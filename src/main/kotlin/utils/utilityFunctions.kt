package dev.artisra.utils

import dev.artisra.calculator.Calculator

fun ongoingCalculationPrompt(calculator: Calculator) {
    var keepProgramAlive = true
    while (keepProgramAlive) {
        val input = readlnOrNull()
        keepProgramAlive = dispatchAction(input, calculator)
    }
}

fun dispatchAction(input: String?, calculator: Calculator): Boolean {

    val singleNumber = input?.toIntOrNull()
    if (singleNumber != null) {
        println(singleNumber)
        return true
    }

    return when {
        input.isNullOrEmpty() -> true
        input.equals("/exit", ignoreCase = true) -> {
            println("Bye!")
            false
        }

        input.equals("/help", ignoreCase = true) -> {
            calculator.printHelp()
            true
        }

        else -> {
            val expression = try {
                input.parseArithmeticExpression()
            } catch (e: InvalidExpression) {
                println(e.message)
                return true
            } catch (e: UnknownCommand) {
                println("Unknown command")
                return true
            } catch (e: Exception) {
                println("Unknown error")
                return true
            }
            val result = calculator.process(expression)
            println(result)
            true
        }
    }
}