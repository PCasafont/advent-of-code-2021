package day04

import Day
import toInts

object Day04 : Day("day04") {
    
    override fun solution1(input: List<String>): String {
        val numbers = input.first().split(",").toInts()
        val bingoCount = input.size / 6
        val bingos = (0 until bingoCount).map { bingoIndex ->
            (1..5).map {
                input[bingoIndex * 6 + it + 1].split(" ").filter { it.isNotEmpty() }.toInts()
            }
        }
        for (currentNumberIndex in numbers.indices) {
            val currentNumber = numbers[currentNumberIndex]
            val markedNumbers = numbers.take(currentNumberIndex + 1)
            val markedBingos = (0 until bingoCount).map { bingoIndex ->
                (0..4).map { x ->
                    (0..4).map { y ->
                        bingos[bingoIndex][x][y] in markedNumbers
                    }
                }
            }
            for (bi in markedBingos.indices) {
                val markedBingo = markedBingos[bi]
                val horizontal = markedBingo.indexOfFirst { it.all { it == true } }
                val vertical = (0..4).indexOfFirst { y -> (0..4).all { x -> markedBingo[x][y] } }
                if (horizontal >= 0 || vertical >= 0) {
                    return (bingos[bi].sumOf { it.filter { it !in markedNumbers }.sum() } * currentNumber).toString()
                }
            }
        }
        return ""
    }
    
    override fun solution2(input: List<String>): String {
        val numbers = input.first().split(",").toInts()
        val bingoCount = input.size / 6
        val bingos = (0 until bingoCount).map { bingoIndex ->
            (1..5).map {
                input[bingoIndex * 6 + it + 1].split(" ").filter { it.isNotEmpty() }.toInts()
            }
        }
        val winners = mutableListOf<Int>()
        for (currentNumberIndex in numbers.indices) {
            val currentNumber = numbers[currentNumberIndex]
            val markedNumbers = numbers.take(currentNumberIndex + 1)
            val markedBingos = (0 until bingoCount).map { bingoIndex ->
                (0..4).map { x ->
                    (0..4).map { y ->
                        bingos[bingoIndex][x][y] in markedNumbers
                    }
                }
            }
            for (bi in markedBingos.indices - winners) {
                val markedBingo = markedBingos[bi]
                val horizontal = markedBingo.indexOfFirst { it.all { it == true } }
                val vertical = (0..4).indexOfFirst { y -> (0..4).all { x -> markedBingo[x][y] } }
                if (horizontal >= 0 || vertical >= 0) {
                    if (winners.size == bingoCount - 1) {
                        return (bingos[bi].sumOf {
                            it.filter { it !in markedNumbers }.sum()
                        } * currentNumber).toString()
                    }
                    else {
                        winners += bi
                    }
                }
            }
        }
        return ""
    }
}
