package day05

import Day
import java.lang.Math.abs
import toInts
import toVec2

object Day05 : Day("day05") {
    
    override fun solution1(input: List<String>): String {
        val vectors = input.map {
            val x = it.split(" -> ")
            x[0].toVec2() to x[1].toVec2()
        }
        val matrix = Array(1000) { IntArray(1000) }
        for ((v1, v2) in vectors) {
            if (v1.x == v2.x) {
                for (y in minOf(v1.y, v2.y)..maxOf(v1.y, v2.y)) {
                    matrix[v1.x][y]++
                }
            } else if (v1.y == v2.y) {
                for (x in minOf(v1.x, v2.x)..maxOf(v1.x, v2.x)) {
                    matrix[x][v1.y]++
                }
            }
        }
        for (y in 0..9) {
            for (x in 0..9) {
                print(matrix[x][y])
            }
            println()
            
        }
        return matrix.sumOf { it.count { it > 1 } }.toString()
    }
    
    override fun solution2(input: List<String>): String {
        val vectors = input.map {
            val x = it.split(" -> ")
            x[0].toVec2() to x[1].toVec2()
        }
        val matrix = Array(1000) { IntArray(1000) }
        for ((v1, v2) in vectors) {
            if (v1.x == v2.x) {
                for (y in minOf(v1.y, v2.y)..maxOf(v1.y, v2.y)) {
                    matrix[v1.x][y]++
                }
            } else if (v1.y == v2.y) {
                for (x in minOf(v1.x, v2.x)..maxOf(v1.x, v2.x)) {
                    matrix[x][v1.y]++
                }
            } else if (abs(v2.x - v1.x) == abs(v2.y - v1.y)) {
                if ((v1.y < v2.y && v1.x < v2.x) || (v1.y > v2.y && v1.x > v2.x)) {
                    var y = minOf(v1.y, v2.y)
                    for (x in minOf(v1.x, v2.x)..maxOf(v1.x, v2.x)) {
                        matrix[x][y]++
                        y++
                    }
                }
                else {
                    var y = maxOf(v1.y, v2.y)
                    for (x in minOf(v1.x, v2.x)..maxOf(v1.x, v2.x)) {
                        matrix[x][y]++
                        y--
                    }
                }
            }
        }
        for (y in 0..9) {
            for (x in 0..9) {
                print(matrix[x][y])
            }
            println()
        
        }
        return matrix.sumOf { it.count { it > 1 } }.toString()
    }
}

fun main() {
    Day05.run()
}
