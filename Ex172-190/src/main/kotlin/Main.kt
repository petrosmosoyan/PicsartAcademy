import kotlin.math.abs
import kotlin.math.roundToInt

fun main() {
    ex172()
    ex173()
    ex174()
    ex175()
    ex176()
    ex177()
    ex178()
    ex179()
    ex180()
    ex181()
    ex182()
    ex183()
    ex184()
    ex185()
    ex186()
    ex187()
    ex188()
    ex189()
    ex190()
}

/************************************ 173 ***********************************/
fun ex172() {
    val n = (1..10).random()

    val range = if (n % 2 == 0) (2..n).filter { it % 2 == 0 } else (1..n).filter { it % 2 != 0 }
    val doubleFactorialInt = range.reduce { acc, i ->
        acc * i
    }

    val doubleFactorialLong = doubleFactorial(n.toLong())

    println("Exercise 172\nn = $n\nDouble Factorial Integer = $doubleFactorialInt\nDouble Factorial Long = $doubleFactorialLong")
    println()
}

fun doubleFactorial(n: Long): Long {
    if ((n % 2 == 0L && n != 2L) || (n % 2 != 0L && n != 1L))
        return n * doubleFactorial(n - 2)

    return n
}

/************************************ 173 ***********************************/
fun ex173() {
    val b = (-20..20).random()
    val a = (-40 until b).random()
    val n = (1..(b - a)).random()

    val crdLength = b - a
    val h = crdLength.toDouble() / n

    val crdList = ex173_1(a..b, h)

    println("Exercise 173\na = $a\nb = $b\nh = $h\ncrdList = $crdList")
    println()
}

fun ex173_1(cordRange: IntRange, h: Double): List<Double> {
    var nextCrd = cordRange.first.toDouble()

    val crdList = mutableListOf<Double>()
    crdList.add(nextCrd)

    while (nextCrd + h <= cordRange.last) {
        nextCrd += h
        crdList += nextCrd
    }

    return crdList
}

/************************************ 174 ***********************************/
fun ex174() {
    val n = (1..10).random()
    val x0 = 2.0

    val crdList = mutableListOf(x0)

    (1..n).forEach { k ->
        crdList += 2 + (1 / crdList[k - 1])
    }

    println("Exercise 174\nn = $n\ncrdList = $crdList")
    println()
}

/************************************ 175 ***********************************/
fun ex175() {
    val n = (1..10).random()
    val x0 = 1.0

    val seqList = mutableListOf(x0)
    (1..n).forEach { k ->
        seqList += (seqList[k - 1] + 1) / k
    }

    val seqListRecursive = mutableListOf(x0).apply {
        ex175_1(n, lastIndex + 1, this)
    }

    println("Exercise 175\nn = $n\ncrdList = $seqList\ncrdListRecursive = $seqListRecursive")
    println()
}

fun ex175_1(n: Int, k: Int, seqList: MutableList<Double>): MutableList<Double> {
    if (k <= n) {
        seqList += (seqList[k - 1] + 1) / k
        ex175_1(n, k + 1, seqList)
    }

    return seqList
}


/************************************ 176 ***********************************/
fun ex176() {
    val n = (2..10).random()

    val fibNumbers = mutableListOf(0, 1).apply {
        fibNumbers(n, lastIndex + 1, this)
    }

    println("Exercise 176\nn = $n\nfibNumbers = $fibNumbers")
    println()
}

fun fibNumbers(n: Int, i: Int, fibList: MutableList<Int>): MutableList<Int> {
    if (i <= n) {
        fibList += fibList[i - 1] + fibList[i - 2]
        fibNumbers(n, i + 1, fibList)
    }

    return fibList
}

/************************************ 177 ***********************************/
fun ex177() {
    val n = (3..10).random()

    val seqList = mutableListOf(1.0, 2.0).apply {
        (3..n).forEach { k ->
            this += (this[k - 2 - 1] + 2 * this[k - 1 - 1]) / 3
        }
    }

    println("Exercise 177\nn = $n\nseqList = $seqList")
    println()
}

/************************************ 178 ***********************************/
fun ex178() {
    val n = (4..10).random()

    val seqList = mutableListOf(1.0, 2.0, 3.0).apply {
        (4..n).forEach { k ->
            this += this[k - 1 - 1] + this[k - 2 - 1] - 2 * this[k - 3 - 1]
        }
    }

    println("Exercise 178\nn = $n\nseqList = $seqList")
    println()
}

/************************************ 179 ***********************************/
fun ex179() {
    val k = (1..100).random()
    val n = (k..100 * k).random()

    var sum = 0
    var qanord = 0

    while (sum + k <= n) {
        sum += k
        qanord++
    }

    val mnacord = n - sum

    println("Exercise 179\nn = $n\nk = $k\nqanord = $qanord\nmnacord = $mnacord")
    println()
}

/************************************ 180 ***********************************/
fun ex180() {
    val n = (1..100).random()
    val result = if (n < 3) false else ex180_1(n)

    println("Exercise 180\nn = $n\nresult = $result")
    println()
}

fun ex180_1(n: Int): Boolean {
    if (n >= 3 && n % 3 == 0)
        return ex180_1(n / 3)

    return n == 1
}

/************************************ 181 ***********************************/
fun ex181() {
    val n = listOf(2, 4, 16, 32, 64).random()
    val k = ex181_1(n, 0)

    println("Exercise 181\nn = $n\nk = $k")
    println()
}

fun ex181_1(n: Int, k: Int): Int {
    if (n > 1)
        return ex181_1(n / 2, k + 1)

    return k
}

/************************************ 182 ***********************************/
fun ex182() {
    val n = (1..100).random()

    val range = (0..n)
    val result = range.last { i ->
        i * i <= n
    }

    println("Exercise 182\nn = $n\nresult = $result")
    println()
}

/************************************ 183 ***********************************/
fun ex183() {
    val n = (1..100).random()

    var k = 0
    while (ex183_1(k) <= n) {
        k++
    }

    println("Exercise 183\nn = $n\nk = $k")
    println()
}

fun ex183_1(k: Int): Int {
    var mult = 1

    mult = if (k == 0)
        3
    else {
        repeat(k) {
            mult *= 3
        }

        mult
    }

    return mult
}

/************************************ 184 ***********************************/
fun ex184() {
    val n = (1..100).random()

    if (n <= 3) {
        println("Exercise 184\nn = $n\nk = No such value which will be satisfy the condition")
        println()
    } else {
        val k = ex184_1(1, 0, n)

        println("Exercise 184\nn = $n\nk = $k")
        println()
    }
}

fun ex184_1(mult: Int, k: Int, n: Int): Int {
    if (mult * 3 < n)
        return ex184_1(mult * 3, k + 1, n)

    return k
}

/************************************ 185 ***********************************/
fun ex185() {
    val percent = (1 until 25).random()
    val deposit = 30_000
    var months = 0
    var money: Double = deposit.toDouble()

    while (money <= 100000) {
        months++
        money = ex185_1(money, percent)
    }


    println("Exercise 185\npercent = $percent\nmonths = $months\nmoney = ${money.roundToInt()}")
    println()
}

fun ex185_1(money: Double, percent: Int) = money + (money * percent) / 100

/************************************ 186 ***********************************/
fun ex186() {
    val percent = 50

    var days = 1
    var dayDistance = 20.0
    var totalDistance = dayDistance


    while (dayDistance <= 80) {
        days++

        dayDistance = ex186_1(dayDistance, percent)
        totalDistance += dayDistance
    }


    println("Exercise 186\npercent = $percent\ndays = $days\ntotalDistance = ${totalDistance.roundToInt()}")
    println()
}

fun ex186_1(dayDistance: Double, percent: Int) = dayDistance + (dayDistance * percent) / 100

/************************************ 187 ***********************************/
fun ex187() {
    val n = (1..100).random()

    val range = (2..n / 2)
    val filterList = range.filter { n % it == 0 }
    val result = filterList.isEmpty()

    println("Exercise 187\nn = $n\nresult = $result")
    println()
}

/************************************ 188 ***********************************/
fun ex188() {
    val n = (1..100).random()

    val fibList = ex188_1(n, mutableListOf(0, 1))

    val result = fibList.contains(n.toLong())

    println("Exercise 188\nn = $n\nresult = $result")
    println()
}

fun ex188_1(n: Int, fibList: MutableList<Long>): List<Long> {
    if (fibList.last() < n) {
        fibList += fibList[fibList.size - 2] + fibList[fibList.size - 1]
        return ex188_1(n, fibList)
    }

    return fibList
}

/************************************ 189 ***********************************/
fun ex189() {
    val n = (1..100).random()

    val fibList = ex189_1(n, mutableListOf(0, 1))

    val result = fibList.last()

    println("Exercise 189\nn = $n\nresult = $result\nfibList = $fibList")
    println()
}

fun ex189_1(n: Int, fibList: MutableList<Long>): List<Long> {
    if (fibList.last() <= n) {
        fibList += fibList[fibList.size - 2] + fibList[fibList.size - 1]
        return ex189_1(n, fibList)
    }

    return fibList
}

/************************************ 190 ***********************************/
fun ex190() {
    val e: Double = ((1..100).random()).toDouble() / 1000
    var k = 3

    val list = mutableListOf(2.0, 3.0)

    while (abs(list.last() - list[list.lastIndex - 1]) > e) {
        list += (list[list.lastIndex - 1] + 2 * list.last()) / 3
        k++
    }

    println("Exercise 190\ne = $e\nk = $k\n|A(k) - A(k-1)| = ${abs(list.last() - list[list.lastIndex - 1])}")
    println()
}