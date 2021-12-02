
abstract class Day(
    private val name: String
) {
    abstract fun solution1(input: List<String>): String
    abstract fun solution2(input: List<String>): String
    
    private fun runSolution(id: Int, solution: (List<String>) -> String) {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput("$name/test_input_$id")
        val testOutput = readOutput("$name/test_output_$id")
        val testSolution = solution(testInput)
        check(testSolution == testOutput) {
            "$name #$id test failed! Expected $testOutput, got $testSolution"
        }
        println("$name #$id test has been successful!")
        
        val input = readInput("$name/input_$id")
        println("$name #$id solution: ${solution(input)}")
    }
    
    fun run() {
        runSolution(1) { solution1(it) }
        runSolution(2) { solution2(it) }
    }
}
