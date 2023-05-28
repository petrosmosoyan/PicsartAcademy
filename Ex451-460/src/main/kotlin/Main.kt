import kotlin.math.pow

fun main(args: Array<String>) {
    val m = (3..10).random()
    val matrix = generateMatrix(m)

    ex451(matrix)
    ex452(matrix)
    ex453(matrix)
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

    val b = mutableListOf<Int>()

    for (rowList in matrix) {
        b += (rowList.first().toFloat().pow(2) + rowList.last().toFloat().pow(2)).toInt()
    }

    println("Exercise 453\nresult = $b")
    println()
}