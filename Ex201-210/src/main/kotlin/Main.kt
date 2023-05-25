fun main(args: Array<String>) {
    ex201()
    ex202()
    ex203()
    ex204()
    ex205()
    ex206()
    ex207()
    ex208()
    ex209()
    ex210()
}

fun ex201() {
    val n = (1..1000).random()
    val length = n.toString().toList().size

    println("Exercise 201\nn = $n\nlength = $length")
    println()
}

fun ex202() {
    val n = (1..1000).random()
    val sum = n.toString().toList().sumOf {
        it.toString().toInt()
    }

    println("Exercise 202\nn = $n\nsum = $sum")
    println()
}

fun ex203() {
    val n = (1..1000).random()
    val multiply = n.toString().toList().map { it.toString().toInt() }.reduce { acc, i ->
        acc * i
    }

    println("Exercise 203\nn = $n\nmultiply = $multiply")
    println()
}

fun ex204() {
    val n = (1..1000).random()
    println("Exercise 204\nn = $n")

    n.toString().toList().reversed().map { it.toString().toInt() }.forEach {
        print("$it ")
    }

    println()
    println()
}

fun ex205() {
    val n = (1..1000).random()
    println("Exercise 205\nn = $n")

    n.toString().toList().map { it.toString().toInt() }.forEach {
        print("$it ")
    }

    println()
    println()
}

fun ex206() {
    val n = (1..1000).random()

    val int = n.toString().toList().reversed().joinToString(separator = "").toInt()

    println("Exercise 206\nn = $n\nint = $int")
    println()
}

fun ex207() {
    val n = (1..1000).random()

    val result = n.toString().toList().map { it.toString().toInt() }.any { it == 2 }

    println("Exercise 207\nn = $n\nresult = $result")
    println()
}

fun ex208() {
    val n = (1..1000).random()

    val result = n.toString().toList().map { it.toString().toInt() }.toSet().size == 1

    println("Exercise 208\nn = $n\nresult = $result")
    println()
}

fun ex209() {
    val n = (1..1000).random()

    val result = n.toString().toList().map { it.toString().toInt() }.any { it % 2 != 0 }

    println("Exercise 209\nn = $n\nresult = $result")
    println()
}

fun ex210() {
    val n = (1..9999).random()
    var evenNumSum = 0
    var oddNumSum = 0
    val intList = n.toString().toList().map { it.toString().toInt() }
    intList.forEachIndexed { index, i ->
        if (i % 2 == 0)
            evenNumSum += index
        else
            oddNumSum += index
    }

    val result = evenNumSum == oddNumSum

    println("Exercise 210\nn = $n\nresult = $result")
    println()
}