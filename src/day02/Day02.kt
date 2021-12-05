package day02

import Day
import Vec2
import parseDirection
import sum

object Day02 : Day("day02") {
    
    override fun solution1(input: List<String>): String {
        val movement = input.map { it.parseDirection() }.sum()
        return (movement.x * movement.y).toString()
    }
    
    override fun solution2(input: List<String>): String {
        val directions = input.map { it.parseDirection() }
        var aim = 0
        val movement = directions.reduce { acc, d ->
            aim += d.y
            acc + Vec2(d.x, aim * d.x)
        }
        return (movement.x * movement.y).toString()
    }
}
