data class Vec2(
    val x: Int,
    val y: Int
) {
    operator fun plus(other: Vec2) = Vec2(x + other.x, y + other.y)
    operator fun minus(other: Vec2) = Vec2(x - other.x, y - other.y)
}

fun Int.horizontal() = Vec2(this, 0)
fun Int.vertical() = Vec2(0, this)

fun String.toVec2() = split(",").let {
    Vec2(it[0].toInt(), it[1].toInt())
}

fun String.parseDirection() = split(" ").let {
    val command = it[0]
    val amount = it[1].toInt()
    when(command) {
        "forward" -> amount.horizontal()
        "down" -> amount.vertical()
        "up" -> (-amount).vertical()
        else -> error("Unknown command: $command")
    }
}

fun Iterable<Vec2>.sum(): Vec2 {
    var sum = Vec2(0, 0)
    for (element in this) {
        sum += element
    }
    return sum
}
