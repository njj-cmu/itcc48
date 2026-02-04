fun main() {

    println("What do you want to do today?")
    println("1 - Age Check")
    println("2 - Score Check")
    val toDo = readln().toInt()

    when(toDo) {
        // If
        1 -> { // If
            print("Input your age: ")
            val age = readln().toInt()

            if (age in 0..17) {
                println("You are underage")
            } else if (age >= 18) {
                println("You can now vote, drink, and drive!")
            } else {
                println("You have entered an invalid number...")
            }
        }
        // When
        2 -> {
            // When
            val score = readln().toInt()

            when(score) {
                in 90..100 -> println("You got an A!")
                in 80..89 -> println("You got a B!")
                in 70..79 -> println("You got a C!")
                in 60..69 -> println("You got a D!")
                in 50..59 -> println("You got an E!")
                in 0..49 -> println("You got an F!")
                else -> println("You have inputted an invalid number! $score")
            }
        }
    }
}