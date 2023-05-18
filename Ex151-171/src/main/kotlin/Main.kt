import kotlin.math.pow
import kotlin.math.sin
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
    ex166()
    ex167()
    ex168()
    ex169()
    ex170()
    ex171()
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
    val n = (9..1000).random()

    var lastValue = n

    while (lastValue % 3 == 0) {
        lastValue /= 3
    }

    val result = lastValue == 1

    println("Exercise 165\nn = $n\nresult = $result")
    println()
}

fun ex166() {
    val n = (16..1000).random()

    var lastValue = n

    while (lastValue % 4 == 0) {
        lastValue /= 4
    }

    val result = if (lastValue == 1) 1 else 0

    println("Exercise 166\nn = $n\nresult = $result")
    println()
}

fun ex167() {
    val x = (-10..10).random()
    val range = 1..30

    var result = false
    for (i in range) {
        val sinVal = sin(((x.toDouble()).pow(i)))

        if (sinVal<0) {
            result = true
            break
        }
    }

    println("Exercise 167\nx = $x\nresult = $result")
    println()
}

fun ex168() {
    val n = (2..100).random()
    val filter = (2..n / 2).filter { n % it == 0 }
    val result = filter.isEmpty()

    println("Exercise 168\nn = $n\nresult = $result")
    println()
}

fun ex169() {
    val x = (2..100).random()
    val y = (2..100).random()

    val filter = (2..(x + y / 2)).filter { (x + y) % it == 0 }
    val result = if (filter.isEmpty()) 5 else 6

    println("Exercise 169\nx = $x\ny = $y\nx + y = ${x + y}\nresult = $result")
    println()
}

fun ex170() {
    val n = (2..100).random()

    var result = n + 1

    while (ex170_1(result) != 1)
        result++

    println("Exercise 170\nn = $n\nresult = $result")
    println()
}

fun ex170_1(x: Int): Int {
    var div = x
    while (div % 2 == 0) {
        div /= 2
    }

    return div
}

fun ex171() {
    val n = (2..100).random()

    val range = 1..n

    val result: Int = range.reduce { acc, i ->
        acc * i
    }

    val result2: Long = ex171_1(n)
//    val result3 = ex171_2(n)

    println("Exercise 171\nn = $n\nresult = $result\nresult2 = $result2")
    println()
}

fun ex171_1(n: Int): Long {
    return if (n == 1)
        n.toLong()
    else
        n * ex171_1(n - 1)
}