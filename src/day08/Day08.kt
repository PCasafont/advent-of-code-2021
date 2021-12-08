package day08

import Day

object Day08 : Day("day08") {
    
    override fun solution1(input: List<String>): String {
        return input.sumOf { line ->
            val digits = line.substringAfter("|").trim().split(" ")
            digits.count { it.length in listOf(2, 3, 4, 7) }
        }.toString()
    }
    
    override fun solution2(input: List<String>): String {
        return input.sumOf { line ->
            val split = line.split("|")
            val sample = split[0].trim().split(" ").map {
                it.toCharArray().sortedArray().concatToString()
            }
            val digits = split[1].trim().split(" ").map {
                it.toCharArray().sortedArray().concatToString()
            }
            val n1 = sample.find { it.length == 2 }!!
            val n7 = sample.find { it.length == 3 }!!
            val n4 = sample.find { it.length == 4 }!!
            val n8 = sample.find { it.length == 7 }!!
            
            val n47sub = n4.toList().subtract(n7.toSet())
            val n6 = sample.find { it.length == 6 && it.toList().containsAll(n47sub) && !it.toList().containsAll(n1.toList()) }!!
            val n9 = sample.find { it.length == 6 && it.toList().containsAll(n47sub) && it.toList().containsAll(n1.toList())  }!!
            val n0 = sample.find { it.length == 6 && it != n6 && it != n9 }!!
    
            val n5 = sample.find { it.length == 5 && it.toList().containsAll(n47sub) }!!
            val n3 = sample.find { it.length == 5 && it.toList().containsAll(n1.toList()) }!!
            val n2 = sample.find { it.length == 5 && it != n5 && it != n3 }!!
            
            val nums = mapOf(n0 to 0, n1 to 1, n2 to 2, n3 to 3, n4 to 4, n5 to 5, n6 to 6, n7 to 7, n8 to 8, n9 to 9)
            
            var mul = 1
            var sum = 0
            digits.reversed().map { nums[it]!! }.forEach {
                sum += it * mul
                mul *= 10
            }
            sum
        }.toString()
    }
}

fun main() {
    Day08.run()
}
