fun main() {
    fun part1(input: List<String>): Int {

        var down = 0
        var up = 0
        var forward = 0

        for(entry in input){
            val instruction = entry.split(" ")
            when(instruction.first()){
                "down" -> {
                    down += instruction.last().toInt()
                }
                "forward" -> {
                    forward += instruction.last().toInt()
                }
                "up" -> {
                    up += instruction.last().toInt()
                }
            }
        }

        return (down - up )* forward
    }

    fun part2(input: List<String>): Int {
        var down = 0
        var up = 0
        var horizontal = 0
        var aim = 0
        var depth = 0

        for(entry in input){
            val instruction = entry.split(" ")
            when(instruction.first()){
                "down" -> {
                    aim += instruction.last().toInt()
                }
                "up" -> {
                    aim -= instruction.last().toInt()
                }
                "forward" -> {
                    val value = instruction.last().toInt()
                    horizontal += value
                    depth += aim * value
                }

            }
        }

        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
