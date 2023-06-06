import java.math.BigInteger

fun main(args: Array<String>) {

    val matrix = generateMatrix()
    println()
    ex491(matrix.toMutableList())
    ex492(matrix.toMutableList())
    ex493(matrix.toMutableList())

    ex497()
    ex498()
    ex499()
    ex500()
    ex501()
    ex502()
    ex503()
    ex504()

    ex646()
    ex647()
    ex648()
    ex649()
    ex650()
    ex651()
    ex652()
    ex653()
    ex654()
    ex655()
    ex656()
    ex657()
}

fun generateMatrix(): List<List<Int>> {
    val m = (3..10).random()
    val n = if (m < 10) (m + 1..10).random() else (3 until m).random()

    val matrix = mutableListOf<List<Int>>()

    var min = 11
    var max = -1

    repeat(m) {
        val rowList = mutableListOf<Int>()

        repeat(n) {
            var randomNumber = (Math.random() * 10).toInt()

            while (randomNumber == min || randomNumber == max) randomNumber = (Math.random() * 10).toInt()

            if (randomNumber < min) min = randomNumber

            if (randomNumber > max) max = randomNumber

            rowList += randomNumber
        }

        matrix += rowList
    }

    return matrix
}

fun generateSquareMatrix(): Array<Array<Int>> {
    val size = (3..10).random()
    val matrix = Array(size) {
        Array<Int>(size) {
            (Math.random() * 10).toInt()
        }
    }

    return matrix
}

fun generateRandomString(length: Int): String {
    val strList = mutableListOf<Char>()

    repeat(length) {
        strList += ('a'..'z').random()
    }

    return strList.joinToString(separator = "")
}

fun generateRandomStringWithOneX(): String {
    val a = (1..100).random()
    val strList = mutableListOf<Char>()

    repeat(a) {
        var char = ('a'..'z').random()

        while (char == 'x' && strList.contains('x')) char = ('a'..'z').random()

        strList += char
    }

    if (!strList.contains('x')) strList[strList.size / 3] = 'x'

    return strList.joinToString(separator = "")
}

fun printMatrix(matrix: List<List<Int>>) {
    println(matrix.joinToString(separator = "\n") {
        it.joinToString(" ")
    })
}

fun <T> MutableList<List<T>>.switchLists(to: Int, from: Int) {
    val fromList = this[from]
    val toList = this[to]
    this[to] = fromList
    this[from] = toList
}

fun <T> MutableList<T>.switchElements(to: Int, from: Int): List<T> {
    val fromElement = this[from]
    val toElement = this[to]
    this[to] = fromElement
    this[from] = toElement

    return this
}

fun Array<Int>.switchElements(to: Int, from: Int): Array<Int> {
    val fromElement = this[from]
    val toElement = this[to]
    this[to] = fromElement
    this[from] = toElement

    return this
}

fun <T> MutableList<T>.moveToFirst(from: Int): List<T> {
    this.add(0, this[from])
    this.removeAt(from + 1)
    return this
}

fun String.addCharAtIndex(char: Char, index: Int) =
    StringBuilder(this).apply { insert(index, char) }.toString()

fun ex491(matrix: MutableList<List<Int>>) {
    var maxElement = 0
    var maxRow = 0
    var maxCol = 0

    matrix.forEachIndexed { row: Int, elements: List<Int> ->
        if (elements.max() > maxElement) {
            maxElement = elements.max()
            maxRow = row
            maxCol = elements.indexOf(maxElement)
        }
    }

    println("Root Matrix, biggest element coordinates are ${"[$maxRow,$maxCol]"} ")
    printMatrix(matrix)
    println()


    if (maxRow > 0) {
        matrix.add(0, matrix[maxRow])
        matrix.removeAt(maxRow + 1)
        println("Matrix Modified By Row")
        printMatrix(matrix)
        println()
    }

    if (maxCol > 0) {
        for ((i, rowList) in matrix.withIndex()) {
            val newRowList = rowList.toMutableList().moveToFirst(maxCol)
            matrix[i] = newRowList
        }

        println("Matrix Modified By Column")
        printMatrix(matrix)
    }
}

fun ex492(matrix: MutableList<List<Int>>) {
    var maxElement = 0
    var minElement = 10

    var maxRow = 0
    var minRow = 0

    matrix.forEachIndexed { row: Int, elements: List<Int> ->
        if (elements.max() > maxElement) {
            maxElement = elements.max()
            maxRow = row
        }

        if (elements.min() < minElement) {
            minElement = elements.min()
            minRow = row
        }
    }

    println()
    println("Ex-492:\nRoot Matrix, max value row is $maxRow and min value row is $minRow")
    printMatrix(matrix)

    if (maxRow == minRow) {
        println("The max and min values are in the same row")
        return
    } else {
        matrix.switchLists(maxRow, minRow)
        println("Ex-492:")
        printMatrix(matrix)
    }
}

fun ex493(matrix: MutableList<List<Int>>) {
    var maxElement = 0
    var maxRow = 0
    var maxCol = 0

    matrix.forEachIndexed { row: Int, elements: List<Int> ->
        if (elements.max() > maxElement) {
            maxElement = elements.max()
            maxRow = row
            maxCol = elements.indexOf(maxElement)
        }
    }

    println()
    println("Ex-493:\nRoot Matrix, biggest element coordinates are ${"[$maxRow,$maxCol]"}")
    printMatrix(matrix)

    matrix.removeAt(maxRow)
    for ((i, row) in matrix.withIndex()) {
        val newRowList = row.toMutableList().apply { removeAt(maxCol) }
        matrix[i] = newRowList
    }

    println("Modified Matrix:")
    printMatrix(matrix)
    println()
}

fun ex497() {
    val matrix = generateSquareMatrix()

    println("Ex-497:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    for (i in matrix.indices) {
        val innerMatrix = matrix[i]
        val maxElement = innerMatrix.max()
        val maxElementIndex = innerMatrix.indexOf(maxElement)

        innerMatrix.switchElements(i, maxElementIndex)
    }

    println("Modified matrix:")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })
    println()
}

fun ex498() {
    val matrix = generateSquareMatrix()

    println("Ex-498:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    for (i in matrix.size - 1 downTo 0) {
        val innerMatrix = matrix[i]
        val minElement = innerMatrix.min()
        val minElementIndex = innerMatrix.indexOf(minElement)

        innerMatrix.switchElements(matrix.size - 1 - i, minElementIndex)
    }

    println("Modified matrix:")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })
    println()
}

fun ex499() {
    val matrix = generateSquareMatrix()

    println("Ex-499:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    var minElement = Int.MAX_VALUE
    var maxElement = Int.MIN_VALUE

    for (array in matrix) {
        val min = array.min()
        val max = array.max()

        if (min < minElement)
            minElement = min

        if (max > maxElement)
            maxElement = max
    }

    val average = (minElement.toDouble() + maxElement) / 2

    val filterList = mutableListOf<Int>()
    for (array in matrix) {
        filterList += array.filter { it % 2 == 0 && it > average }
    }

    val result = filterList.sum()

    println("result = $result")
    println()
}

fun ex500() {
    val matrix = generateSquareMatrix()

    println("Ex-500:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    var sum = 0
    for (array in matrix) {
        sum += array.min() * array.max()
    }

    val result = sum / matrix.size

    println("result = $result")
    println()
}

fun ex501() {
    val matrix = generateSquareMatrix()

    println("Ex-501:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    val list = mutableListOf<BigInteger>()
    for ((index, array) in matrix.withIndex()) {
        val filterList = mutableMapOf<Int, Int>()

        array.filterIndexed { i: Int, it: Int ->
            if (it % 2 == 0 && it < array[index]) {
                filterList[i] = it
                true
            } else
                false
        }

        val newElement = if (filterList.isEmpty() || filterList.keys.sum() % 2 == 0)
            1.toBigInteger()
        else {
            var multiply = 1.toBigInteger()
            for (i in filterList.values) {
                multiply *= i.toBigInteger()
            }

            multiply
        }

        list += newElement
    }

    println("Vector = $list")
    println()
}

fun ex502() {
    val matrix = generateSquareMatrix()

    println("Ex-502:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    val list = mutableListOf<Int>()
    for (array in matrix) {
        val element = array.filter { it % 2 != 0 }.max()
        list += element
    }

    println("Vector = $list")
    println()
}

fun ex503() {
    val matrix = generateSquareMatrix()

    println("Ex-503:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    val list = mutableListOf<Int>()
    for (array in matrix) {
        val element = array.filter { it % 2 == 0 }.min()
        list += element
    }

    println("Vector = $list")
    println()
}

fun ex504() {
    val matrix = generateSquareMatrix()

    println("Ex-504:\nRoot Matrix")
    println(matrix.joinToString("\n") {
        it.joinToString(" ")
    })

    val list = mutableListOf<Int>()
    for ((index, array) in matrix.withIndex()) {
        val filterList = mutableMapOf<Int, Int>()

        array.filterIndexed { i: Int, element ->

            if (element % 2 != 0 && element > array[array.lastIndex - index]) {
                filterList[i] = element
                true
            } else
                false

        }

        val newElement = if (filterList.isEmpty() || filterList.keys.sum() % 2 == 0)
            0
        else {
            filterList.values.sum()
        }

        list += newElement
    }

    println("Vector = $list")
    println()
}

fun ex646() {
    val n = (1..26).random()
    val string = generateRandomString(n)
    println("Ex-646\nstring = $string\nresult = ${string.count { it == 'a' }}")
    println()
}

fun ex647() {
    val n = (1..26).random()
    val string = generateRandomString(n)
    println("Ex-647\nstring = $string\nresult = ${string == string.reversed()}")
    println()
}

fun ex648() {
    val string = generateRandomStringWithOneX()
    val subString = string.substring(string.indexOf('x'))
    println("Ex-648\nstring = $string\nresult = ${subString.count { it == 'o' }}")
    println()
}

fun ex649() {
    val string = "sdhzjguowqeklsdasdjmhqzywihj"

    val subString = string.substring(string.indexOfFirst {
        it == 'z'
    } + 1 until string.indexOfLast { it == 'z' })

    println("Ex-649\nstring = $string\nresult = ${subString.length}")
    println()
}

fun ex650() {
    val n = (1..26).random()
    val string1 = generateRandomString(n)
    val string2 = generateRandomString(n)

    println("Ex-650\nstring1 = $string1\nstring2 = $string2\nresult = ${string1.filter { string2.contains(it) }.length}")
    println()
}

fun ex651() {
    val n = (1..26).random()
    val string = generateRandomString(n)
    val result = string.filter { filterIt ->
        string.count { it == filterIt } == 1
    }

    println("Ex-651\nstring = $string\nresult = $result")
    println()
}

fun ex652() {
    val n = (1..26).random()
    val string1 = generateRandomString(n)
    val string2 = generateRandomString(n)

    val result = string2.filter { filterIt ->
        string1.any { it == filterIt }
    }

    println("Ex-652\nstring1 = $string1\nstring2 = $string2\nresult = $result")
    println()
}

fun ex653() {
    val n = (1..26).random()
    val string = generateRandomString(n)

    println("Ex-653\nstring1 = $string\nresult = ${string.replace("a", "ac")}")
    println()
}

fun ex654() {
    val n = (1..26).random()
    val string = generateRandomString(n)

    println("Ex-654\nstring1 = $string\nresult = ${string.filter { it != 'a' }}")
    println()
}

fun ex655() {
    val n = (1..26).random()
    val string = generateRandomString(2 * n + 1)

    println("Ex-655\nstring1 = $string\nresult = ${string.reversed()}")
    println()
}

fun ex656() {
    val n = (1..26).random()
    val string = generateRandomString(n)

    println("Ex-656\nstring1 = $string\nresult = ${string.replace("x", "yy")}")
    println()
}

fun ex657() {
    val n = (1..26).random()
    val string = generateRandomString(n)

    var startPoint = 0
    var endPoint = 1
    val list = mutableListOf<Char>()

    while (endPoint < string.length) {
        val bigger = if (string[startPoint] < string[endPoint]) string[endPoint] else string[startPoint]

        list += listOf(bigger)

        startPoint = endPoint + 1
        endPoint += 2
    }

    if (string.length % 2 != 0)
        list += string.last()

    println("Ex-657\nstring1 = $string\nresult = $list")
    println()
}