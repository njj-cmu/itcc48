/**
 * Only accepts a List filled with Integer values...
 */
fun printList(list:List<Int>) {
    println("This numerical list's values are the following: ")
    // Regular for-loop use
    /*
        Use it for complex logic, or when you want to use keywords like:
            return, continue, break, etc.
     */
    for(number in list) {
        print(number)
        print(" ")
    }
}

/**
 * Only accepts an Array filled with Integer values...
 */
fun printArray(list:Array<Int>) {
    println("This numerical array's values are the following: ")

    // Indexed for-loop use
    // Useful if you want to utilize for-loop, but you also want to check the index

    for(index in list.indices) {
        // Safer use, but you can do a shortcut if you want
        val value = list[index]
        print(value)
        print(" ")
    }
}

/*
    To print an array with different data type inside, you have to create its relevant function that accepts
    the data type you want.
 */
/**
 *  Only accepts an array with String values inside.
 */
fun printStringArray(arr:Array<String>) {
    println("This string array's values are the following: ")

    for(str in arr) {
        print(str)
        print(" ")
    }
}

/**
 * This accepts any iterable variable (e.g., List, Array, etc.).
 */
fun printCollection(collection:Iterable<Int>) {
    println("This collection's values are the following: ")

    // Iterate using forEach, only recommended for simple or functional use
    collection.forEach { item ->
        print(item)
        print(" ")
    }
}

fun main() {

    /*
        Kotlin supports many collections.
        You just need to know which one to use based on the situation.

        List -> Ordered
        Set -> Unique elements
        Map -> Quick lookup of value based on key.
     */

    // List Collection
    val constantNumbers = listOf(1,2,3,4,5,6,7,8,9,10)  // Immutable List
    val arrNumbers = arrayOf(1,2,3,5,8,11)              // Immutable Array

    val changeableNumbers = mutableListOf(-1,0,2,3)            // Mutable List

    printList(constantNumbers)
    printArray(arrNumbers)
    printCollection(changeableNumbers)

    val stringArray = arrayOf("Mercedes", "Ferrari", "Chevrolet")   // Immutable Array of
    printStringArray(stringArray)
}