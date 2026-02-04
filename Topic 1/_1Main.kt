fun main() {

    /*
        NOTE
            var -> Mutable variable
            val -> Immutable variable
     */

    // Data Types

    // Declaring variable as specific Int Type
    val myInt:Int = 123

    // Declaring variable as specific Double Type
    val myDouble:Double = 1.0677

    // Declaring variable as specific Boolean Type
    val myBool:Boolean = true

    // Declaring variable as specific String Type
    val str:String = "String Test"

    // Sample print
    println(myInt)
    println(myDouble)
    println(myBool)
    println(str)

    // More Examples
    var name:String = "John" // Mutable String variable
    val last:String = "Dale" // Immutable String variable

    // Change name
    name = "Jane"   // Correct since "name" is of var / mutable
    // last = "Doe" // Not correct since "last" is val / immutable

    // Sample Output
    // Printing by referencing variables
    println("$name $last")

    // Type-inferred variables
    val num = 100               // Int-inferred variable
    val pi = 3.14159265         // Double-inferred variable
    val yourName = "Name"       // String-inferred variable

    var middleName:String? = null   // Nullable String variable
    var salary:Double? = null       // Nullable Double variable

    middleName = "N/A"
    salary = 32692.50
}