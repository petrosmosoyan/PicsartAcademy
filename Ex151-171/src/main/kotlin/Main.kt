import kotlin.math.sqrt

fun main() {

    ex151()
    ex152()
    ex153()
    ex154()
    ex155()
    ex156()
    ex157()
    ex158()
    ex159()
    ex160()
    ex161()
    ex162()
    ex163()
    ex164()
    ex165()
}

fun ex151() {
    val n = (1..15).random()

    val range = 1..n / 2
    val filterRange = range.filter { n % it == 0 }
    val result = filterRange.sum() + n
    println("Exercise 151\nn = $n\nsum = $result")
    println()
}

fun ex152() {
    val n = (1..15).random()
    val range = 1..n / 2
    val filterRange = range.filter { n % it == 0 }

    var result = 1
    filterRange.forEach {
        result *= it
    }

    result *= n
    println("Exercise 152\nn = $n\nresult = $result")
    println()
}

fun ex153() {
    val n = (1..15).random()

    val range = 1..n / 2
    val filterRange = range.filter { n % it == 2 }
    val result = filterRange.sum()
    println("Exercise 153\nn = $n\nsum = $result")
    println()
}

fun ex154() {
    val n = (1..15).random()
    val range = 1..n / 2
    val filterRange = range.filter { n % it == 3 }

    var result = 1
    filterRange.forEach {
        result *= it
    }

    println("Exercise 154\nn = $n\nresult = $result")
    println()
}

fun ex155() {
    val range = 10 until 100
    val filterRange = range.filter { it % 3 == 0 }

    val result = filterRange.sum()

    println("Exercise 155\nresult = $result")
    println()
}

fun ex156() {
    val range = 10 until 100
    val filterRange = range.filter { it % 3 == 0 && it % 5 == 0 }

    var result = 1L
    filterRange.forEach {
        result *= it
    }


    println("Exercise 156\nresult = $result")
    println()
}

fun ex157() {
    val range = 100 until 1000
    val filterRange = range.filter { it % 5 != 0 }

    val result = filterRange.sum()

    println("Exercise 157\nresult = $result")
    println()
}

fun ex158() {
    val range = 100 until 1000
    val filterRange = range.filter { it % 2 != 0 && it % 3 != 0 }

    var result = 1L
    filterRange.forEach {
        result *= it
    }

    println("Exercise 158\nresult = $result")
    println()
}

fun ex159() {
    val range = 100 until 1000
    val filterRange = range.filter { it % 3 == 1 && it % 4 == 2 }

    var result = 1.0
    filterRange.forEach {
        result *= it
    }

    println("Exercise 159\nresult = $result")
    println()
}

fun ex160() {
    val range = 100 until 1000
    val result = range.first { (sqrt(it * 16.0)) / (sqrt(it * 16.0)).toInt() == 1.0 }

    println("Exercise 160\nresult = $result")
    println()
}

fun ex161() {
    val range = 1000 until 10000
    val result = range.first { (sqrt(it * 26.0)) / (sqrt(it * 26.0)).toInt() == 1.0 }

    println("Exercise 161\nresult = $result")
    println()
}

fun ex162() {
    val range = 1000 until 10000
    val result = range.last { (sqrt(it * 14.0)) / (sqrt(it * 14.0)).toInt() == 1.0 }

    println("Exercise 162\nresult = $result")
    println()
}

fun ex163() {
    val range = 1000 until 10000
    val result = range.last { (sqrt(it * 18.0)) / (sqrt(it * 18.0)).toInt() == 1.0 }

    println("Exercise 163\nresult = $result")
    println()
}

fun ex164() {
    val rangeEnd = sqrt(999.0).toInt()
    val n = (10..rangeEnd).random()

    val range = 100 until 1000
    val result = range.first { sqrt(it.toDouble()) > n.toDouble() }

    println("Exercise 164\nresult = $result")
    println()
}

fun ex165() {
    val n = (3..9).random()

    val range = 100 until 1000
    val result = range.first { sqrt(it.toDouble()) > n.toDouble() }

    println("Exercise 165\nresult = $result")
    println()
}