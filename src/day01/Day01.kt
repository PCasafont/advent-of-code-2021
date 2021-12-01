package day01

import Day
import toInts

object Day01 : Day("day01") {
    override fun solution1(input: List<String>): String {
        val depths = input.toInts()
        return depths.drop(1).filterIndexed { i, depth -> depth > depths[i] }.count().toString()
    }
    
    override fun solution2(input: List<String>): String {
        val depths = input.toInts()
        val windows = depths.windowed(3).map { it.sum() }
        return windows.drop(1).filterIndexed { i, depth -> depth > windows[i] }.count().toString()
    }
}
