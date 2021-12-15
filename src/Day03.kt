fun main() {
    fun part1(input: List<String>): Int {

        val zeroCounter = mutableMapOf<Int, Int>()
        val oneCounter = mutableMapOf<Int, Int>()

        for (item in input) {
            val bits = item.split("")
            bits.forEachIndexed { index, bit ->
                when (bit) {
                    "0" -> {
                        val sum = zeroCounter[index] ?: 0
                        zeroCounter[index] = sum + 1
                    }
                    "1" -> {
                        val sum = oneCounter[index] ?: 0
                        oneCounter[index] = sum + 1
                    }
                }
            }

        }

        val size = input.first().length

        var alpha = ""
        var beta = ""

        for (i in 0..size) {

            val qZero = zeroCounter[i] ?: 0
            val qOne = oneCounter[i] ?: 0

            if (qZero > qOne) {
                alpha += "0"
                beta += "1"
            }

            if (qZero < qOne) {
                beta += "0"
                alpha += "1"
            }
        }

        return alpha.toInt(2) * beta.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val zeroCounter = mutableMapOf<Int, Int>()
        val oneCounter = mutableMapOf<Int, Int>()

        for (item in input) {
            val bits = item.split("")
            bits.forEachIndexed { index, bit ->
                when (bit) {
                    "0" -> {
                        val sum = zeroCounter[index] ?: 0
                        zeroCounter[index] = sum + 1
                    }
                    "1" -> {
                        val sum = oneCounter[index] ?: 0
                        oneCounter[index] = sum + 1
                    }
                }
            }
        }

        val size = input.first().length

        return 0
    }

    fun getOxygenRate(
        position: Int,
        numbers: List<String>,
        zeroCounter: Map<Int, Int>,
        onesCounter: Map<Int, Int>
    ): Int {

        if (numbers.size == 1)
            return numbers.first().toInt(2)

        val quantityZero = zeroCounter[position] ?: 0
        val quantityOnes = onesCounter[position] ?: 0

        val newNumbers = if (quantityOnes == quantityZero) {
            numbers.filter { it.split("")[position] == "1" }
        } else if (quantityOnes > quantityZero) {
            numbers.filter { it.split("")[position] == "1" }
        } else {
            numbers.filter { it.split("")[position] == "0" }
        }

        // recursivelly

        return 0
    }

    fun getCO2(countZero: Int, countOnes: Int, input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}