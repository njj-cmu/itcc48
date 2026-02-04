// Variables
var operator:Int? = null

// All of these are single-expression functions

/**
 * Add function.
 */
fun add(a:Int, b:Int) = a + b

/**
 * Overloaded add function for two double inputs.
 */
fun add(a:Double, b:Double) = a + b

/**
 * Subtract function.
 */
fun subtract(a:Int, b:Int) = a - b

/**
 * Multiply function
 */
fun mult(a:Int, b:Int) = a * b

/**
 * Division function
 */
fun divide(a:Int, b:Int) = a / b

// After this, are regular functions
/**
 * Overloaded add function with vararg for multiple integer inputs.
 */
fun add(vararg nums:Int):Int {
    var sum:Int = 0

    for(num in nums) {
        sum += num
    }

    return sum
}

fun input(varName:String): Int {
    print("Input the value of $varName: ")
    return readln().toInt()
}

fun setOperator() {
    println("Choose the operation:")
    println("1 - Addition")
    println("2 - Subtract")
    println("3 - Multiplication")
    println("4 - Division")
    print("Input: ")
    operator = readln().toInt()
}

fun executeOperation(a:Int, b:Int) {
    when(operator) {
        1 -> println("$a + $b = ${add(a, b)}")
        2 -> println("$a - $b = ${subtract(a, b)}")
        3 -> println("$a * $b = ${mult(a , b)}")
        4 -> {
            if(b == 0) {
                println("Invalid value of b (divisor)!")
            }
            else {
                println("$a / $b = ${divide(a, b)}")
            }
        }
        else -> {
            println("Invalid operator given!")
        }
    }
}

fun main() {

    var cont = "Yes"

    while(cont == "Yes") {
        val a = input("a")
        val b = input("b")
        setOperator()
        executeOperation(a, b)
        print("Do you want to try again (Yes/No)?: ")
        cont = readln()
    }
    println("Exiting...")
}