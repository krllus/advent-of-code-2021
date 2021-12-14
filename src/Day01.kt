fun main() {
    fun part1(input: List<String>): Int {

        var qtdIncreased = 0
        var qtdDecreased = 0

        val numbers = input.map { Integer.parseInt(it) }
        var previousElement: Int
        for(index in 1 until numbers.size){
            previousElement = numbers[index - 1]
            val currentElement = numbers[index]
            if(previousElement > currentElement){
                qtdDecreased++
            }
            if(previousElement < currentElement){
                qtdIncreased++
            }
        }

        return qtdIncreased
    }

    fun part2(input: List<String>): Int {
        var qtdIncreased = 0
        var qtdDecreased = 0

        val numbers = input.map { Integer.parseInt(it) }

        var previousSum: Int
        for(index in 0 until numbers.size - 3){
            previousSum = numbers[index] + numbers[index + 1] + numbers[index + 2]
            val currentSum = numbers[index + 1] + numbers[index + 2] + numbers[index + 3]
            if(previousSum > currentSum){
                qtdDecreased++
            }
            if(previousSum < currentSum){
                qtdIncreased++
            }
        }

        return qtdIncreased
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
