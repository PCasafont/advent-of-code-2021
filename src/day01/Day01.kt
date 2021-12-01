package day01

import Day

object Day01 : Day("day01") {
    override fun solution1(input: List<String>): String {
        val depths = input.mapNotNull { it.toIntOrNull() }
        return depths.asSequence().drop(1).filterIndexed { i, depth ->
            depth > depths[i]
        }.count().toString()
    }
    
    override fun solution2(input: List<String>): String {
        val depths = input.mapNotNull { it.toIntOrNull() }
        val windows = depths.asSequence().windowed(3).map { it.sum() }.toList()
        return windows.drop(1).filterIndexed { i, depth ->
            depth > windows[i]
        }.count().toString()
    }
}
