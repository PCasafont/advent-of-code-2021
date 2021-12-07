package day06

import Day
import toInts

object Day06 : Day("day06") {
    
    override fun solution1(input: List<String>): String {
        var fish = input.first().split(",").toInts()
        repeat(80) {
            val bornFish = mutableListOf<Int>()
            fish = fish.map {
                if (it == 0) {
                    bornFish += 8
                    6
                } else {
                    it - 1
                }
            } + bornFish
        }
        return fish.size.toString()
    }
    
    override fun solution2(input: List<String>): String {
        var fish = input.first().split(",").toInts().groupingBy { it }.eachCount().mapValues { it.value.toLong() }.toMutableMap()
        repeat(256) {
            var bornFish = 0L
            fish = fish.map { (n, count) ->
                val newN = if (n == 0) {
                    bornFish += count
                    9
                } else {
                    n - 1
                }
                newN to count
            }.toMap().toMutableMap()
            fish[6] = (fish[6] ?: 0) + (fish[9] ?: 0)
            fish[8] = (fish[8] ?: 0) + bornFish
            fish[9] = 0
            println(it + 1)
            println(fish.toSortedMap())
        }
        return fish.values.sum().toString()
    }
}

fun main() {
    Day06.run()
}
