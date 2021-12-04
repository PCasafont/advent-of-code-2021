package day03

import Day

object Day03 : Day("day03") {
    
    override fun solution1(input: List<String>): String {
        val bGamma = (0 until input.first().length).map { index ->
            if (input.count { it[index] == '0' } > input.size / 2) {
                '0'
            } else {
                '1'
            }
        }.joinToString(separator = "")
        val bEpsilon = (0 until input.first().length).map { index ->
            if (input.count { it[index] == '0' } > input.size / 2) {
                '1'
            } else {
                '0'
            }
        }.joinToString(separator = "")
        val result = bGamma.toInt(2) * bEpsilon.toInt(2)
        return result.toString()
    }
    
    override fun solution2(input: List<String>): String {
        val mInput = input.toMutableList()
        var index = 0
        while (index < input.first().length && mInput.size > 1) {
            val mostCommon = if (mInput.count { it[index] == '0' } > mInput.size / 2) {
                '0'
            } else {
                '1'
            }
            mInput.removeIf { it[index] != mostCommon }
            index++
        }
        val mInput2 = input.toMutableList()
        index = 0
        while (index < input.first().length && mInput2.size > 1) {
            val mostCommon = if (mInput2.count { it[index] == '0' } > mInput2.size / 2) {
                '1'
            } else {
                '0'
            }
            mInput2.removeIf { it[index] != mostCommon }
            index++
        }
        val result = mInput.first().toInt(2) * mInput2.first().toInt(2)
        return result.toString()
    }
}
