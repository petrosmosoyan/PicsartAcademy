fun main() {
    ex173()
    ex174()
    ex175()
    ex176()
    ex177()
    ex178()
    ex179()
    ex180()
    ex181()
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
    val k = ex181_1(n,0)

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
    val n = listOf(2, 4, 16, 32, 64).random()
    val k = ex181_1(n,0)

    println("Exercise 182\nn = $n\nk = $k")
    println()
}

fun ex181_1(n: Int, k: Int): Int {
    if (n > 1)
        return ex181_1(n / 2, k + 1)

    return k
}