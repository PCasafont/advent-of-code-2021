package day09

import Day
import Vec2
import day09.Day09.getCoerced

object Day09 : Day("day09") {
    
    override fun solution1(input: List<String>): String {
        val grid = input.map { it.toCharArray().map { it.digitToInt() } }
        var sum = 0
        for (y in grid.indices) {
            for (x in (0 until input.first().length)) {
                val v = grid.getCoerced(x, y) ?: 10
                val a = grid.getCoerced(x + 1, y) ?: 10
                val b = grid.getCoerced(x - 1, y) ?: 10
                val c = grid.getCoerced(x, y + 1) ?: 10
                val d = grid.getCoerced(x, y - 1) ?: 10
                if (v < a && v < b && v < c && v < d) {
                    sum += v + 1
                }
            }
        }
        return sum.toString()
    }
    
    private fun List<List<Int>>.getCoerced(x: Int, y: Int) =
        if (y < 0 || y >= size) null else this[y].let {
            if (x < 0 || x >= it.size) null else it[x]
        }
    
    override fun solution2(input: List<String>): String {
        val grid = input.map { it.toCharArray().map { it.digitToInt() } }
        val lowPoints = mutableListOf<Vec2>()
        for (y in grid.indices) {
            for (x in (0 until input.first().length)) {
                val v = grid.getCoerced(x, y) ?: 10
                val a = grid.getCoerced(x + 1, y) ?: 10
                val b = grid.getCoerced(x - 1, y) ?: 10
                val c = grid.getCoerced(x, y + 1) ?: 10
                val d = grid.getCoerced(x, y - 1) ?: 10
                if (v < a && v < b && v < c && v < d) {
                    lowPoints += Vec2(x, y)
                }
            }
        }
        val basins = lowPoints.map { lowPoint ->
            val visited = mutableSetOf<Vec2>()
            grid.visit(lowPoint.x, lowPoint.y, visited)
            visited
        }.distinct()
        var mul = 1
        basins.sortedByDescending { it.size }.take(3).forEach {
            mul *= it.size
        }
        return mul.toString()
    }
    
    fun List<List<Int>>.visit(x: Int, y: Int, dst: MutableSet<Vec2>) {
        val pos = Vec2(x, y)
        if ((getCoerced(x, y) ?: 9) == 9 || dst.contains(pos)) {
            return
        }
        
        dst += pos
        
        visit(x + 1, y, dst)
        visit(x - 1, y, dst)
        visit(x, y + 1, dst)
        visit(x, y - 1, dst)
    }
}

fun main() {
    Day09.run()
}
