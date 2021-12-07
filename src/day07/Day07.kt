package day07

import Day
import kotlin.math.absoluteValue
import toInts

object Day07 : Day("day07") {
    
    override fun solution1(input: List<String>): String {
        val positions = input.first().split(",").toInts()
        val best = (positions.minOrNull()!!..positions.maxOrNull()!!).minOf { pos ->
            positions.sumOf { (it - pos).absoluteValue }
        }
        return best.toString()
    }
    
    override fun solution2(input: List<String>): String {
        val positions = input.first().split(",").toInts()
        val best = (positions.minOrNull()!!..positions.maxOrNull()!!).minOf { pos ->
            positions.sumOf { (1..(it - pos).absoluteValue).sum() }
        }
        return best.toString()
    }
}

fun main() {
    Day07.run()
}
