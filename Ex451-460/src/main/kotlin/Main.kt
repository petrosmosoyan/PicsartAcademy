import java.math.BigInteger
import kotlin.math.pow

fun main(args: Array<String>) {
    val m = (3..10).random()
    val matrix = generateMatrix(m)

    ex451(matrix)
    ex452(matrix)
    ex453(matrix)
    ex454(matrix)
    ex455(matrix)
    ex456()
    ex457(matrix)
    ex458(matrix)
    ex459()
    ex460(matrix)
}

fun generateMatrix(m: Int): List<List<Int>> {
    val matrix = mutableListOf<List<Int>>()

    repeat(m) {
        val rowList = mutableListOf<Int>()

        repeat(m) {
            rowList += (1..9).random()
        }

        matrix += rowList
    }

    return matrix
}

fun generateMatrixWithNegativeValues(m: Int): List<List<Int>> {
    val matrix = mutableListOf<List<Int>>()

    repeat(m) {
        val rowList = mutableListOf<Int>()

        repeat(m) {
            rowList += (-9..9).random()
        }

        matrix += rowList
    }

    return matrix
}

fun printMatrix(matrix: List<List<Int>>) {
    for (rowList in matrix) {
        println(rowList.joinToString(separator = " "))
    }
}

fun ex451(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val b = mutableListOf<Int>()

    for ((rowNumber, rowList) in matrix.withIndex()) {
        b += (rowList[rowNumber] + rowList.reversed()[rowNumber]) / 2
    }

    println("Exercise 451\nresult = $b")
    println()
}

fun ex452(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val b = mutableListOf<Int>()

    for (rowList in matrix) {
        b += (rowList.first().toFloat().pow(2) + rowList.last().toFloat().pow(2)).toInt()
    }

    println("Exercise 452\nresult = $b")
    println()
}

fun ex453(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val a = (1..9).random()
    val range = a..9

    val b = mutableListOf<Int>()

    for (rowList in matrix) {
        val sum = rowList.filter { it in range }.sum()
        b += sum
    }

    println("Exercise 453\nrange = $range\nresult = $b")
    println()
}

fun ex454(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val b = mutableListOf<BigInteger>()

    for (rowList in matrix) {
        var multiply = 1.toBigInteger()
        val convertList = rowList.map { it.toFloat().pow(2).toInt() }

        for (item in convertList) {
            multiply *= item.toBigInteger()
        }

        b += multiply
    }

    println("Exercise 454\nresult = $b")
    println()
}

fun ex455(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val b = mutableListOf<Int>()

    for ((rowNumber, rowList) in matrix.withIndex()) {
        b += rowList[rowNumber] * rowList.reversed()[rowNumber]
    }

    println("Exercise 455\nresult = $b")
    println()
}

fun ex456() {
    val m = (3..10).random()
    val matrix = generateMatrixWithNegativeValues(m)

    printMatrix(matrix)

    val b = mutableListOf<Int>()

    for (rowList in matrix) {
        b += rowList.filter { it > 0 }.size
    }

    println("Exercise 456\nresult = $b")
    println()
}

fun ex457(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val b = mutableListOf<Int>()

    for (rowList in matrix) {
        b += rowList.filter { it % 2 != 0 }.sum()
    }

    println("Exercise 457\nresult = $b")
    println()
}

fun ex458(matrix: List<List<Int>>) {
    printMatrix(matrix)
    val k = (1..9).random()

    val b = mutableListOf<Int>()

    for (rowList in matrix) {
        b += rowList.filter { it > k }.size
    }

    println("Exercise 458\nk = $k\nresult = $b")
    println()
}

fun ex459() {
    val m = (3..10).random()
    val matrix = generateMatrixWithNegativeValues(m)

    printMatrix(matrix)

    val b = mutableListOf<BigInteger>()

    for (rowList in matrix) {
        var multiply = 1.toBigInteger()

        rowList.filter { it < 0 }.forEach {
            multiply *= it.toBigInteger()
        }

        b += multiply
    }

    println("Exercise 459\nresult = $b")
    println()
}

fun ex460(matrix: List<List<Int>>) {
    printMatrix(matrix)

    val b = mutableListOf<BigInteger>()

    for (rowList in matrix) {
        var multiply = 1.toBigInteger()
        rowList.filter { it % 2 == 0 }.map { it.toFloat().pow(2).toInt() }.forEach {
            multiply *= it.toBigInteger()
        }

        b += multiply
    }

    println("Exercise 460\nresult = $b")
    println()
}