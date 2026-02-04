/*
    When creating classes, a class is composed of a header and its body.
    The header is where the object is constructed and its initial state is defined.

    Variables can be internally defined and not included in the header.
    So why?

    -------
    Variables / Parameters must be put in the header if the object cannot exist or doesn't mean much without it.
    For example, in a Person class, it is very important to know their name, age, or address.

    Variables can be internally defined inside the body if it can change later or has a default value.
    For example, email can be empty at first, but changed later.
 */

class Person(val name: String, var age: Int) {
    var email:String = "N/A"
    var number:String = "N/A"

    fun talk() {
        println("Hello, I am ${name}, and I am ${age} years old")
    }

    fun walk(location: String) {
        println("Walking to: $location")
    }
}

/*
    We can also provide a default values in some variables in the header. But this doesn't mean we should put
    everything inside the header too.

    The purpose of default values in the header is to:
        1. Reduce constructor overloads
        2. Support optional input
        3. Make object creation ergonomic
    It is not meant to dump everything into the constructor.

    The class below can be interpreted as: if no brand is provided, the system supplies a reasonable input, which is
    "Ferrari" in this case.
 */

class Vehicle(val brand: String = "Ferrari", val transmission:String = "Manual") {
    val wheels: Int = 4
    var isOn: Boolean = false

    fun start() {
        if(!isOn) {
            isOn = true
            println("Car has been turned on.")
        }
        else {
            println("Car is already on.")
        }
    }

    fun off() {
        if(isOn) {
            isOn = false
            println("Car has been turned off.")
        }
        else {
            println("Car is already off.")
        }
    }

    fun drive(location: String) {
        if(isOn) {
            println("Driving to: $location")
        }
        else {
            println("Car must be turned on before you can drive.")
        }
    }
}

/*
    Note that:
        Constructor parameters represent inputs. Body properties represent state over time.
        This will be heavily implied in Topic 3.
 */

fun main() {

    // Instantiang an object

    println("Creating person object: claire")
    val claire = Person("Claire", 12)

    // Printing claire's attributes
    println("Name: ${claire.name}")
    println("Age: ${claire.age}")

    println("Creating vehicle object: raize")
    val raize = Vehicle("Toyota", "CVT")

    // Printing raize's attributes
    println("Vehicle Brand: ${raize.brand}")
    println("Transmission Type: ${raize.transmission}")
    println("No. of Wheels: ${raize.wheels}")
}