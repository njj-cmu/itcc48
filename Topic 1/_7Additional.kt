data class Student (
    val id: String,
    val fName: String,
    val lName: String,
    val program: String,
    val yearLevel: Int,
    val grade: Double,
)

// ENUMERATION
enum class Program {
    BSIT,
    BSEE,
    BSAccountancy
}

fun main() {
    val claire = Student("1001", "Claire", "Obscur", "BSIT", 3, 2.50)
    val john = Student("1002", "John", "Doe", "BSIT", 3, 1.75)
    val jane = Student("1003", "Jane", "Doe", "BSEE", 2, 1.44)
    val julian = Student("1004", "Julian", "Marte", "BSIT", 4, 1.22)
    val random = Student("1005", "Ran", "Dom", "BSEE", 1, 1.56)
//    val claire1 = Student("1006", "Claire", "Obscur", "BSIT", 3, 2.50)

    /*
        MUTABLE     ->  if the shape of the collection changes (size of the collection)
        IMMUTABLE
     */

    val students = mutableListOf(claire, john, jane, julian, random, claire)
    val ordered = students.sortBy { student -> student.lName }
    val ordered2 = students.sortBy { student -> student.program }

//    val present = mutableSetOf<Student>()
//    val absent = mutableSetOf<Student>()
//    val late = mutableSetOf<Student>()
//    val excused = mutableSetOf<Student>()

    val attendance = mutableMapOf(
        "present" to mutableSetOf<Student>(),
        "absent" to mutableSetOf<Student>(),
        "late" to mutableSetOf<Student>(),
        "excused" to mutableSetOf<Student>()
    )

    //  groupBy     =>      Map<Key, List<Elements>>

    //  groupBy     =>      Map<Program, List<Student>>
    val groupedByProgram = students.groupBy { student -> student.program }
    /*
        "BSIT" => [claire, john, julian]
        "BSEE" => [jane, random]
     */

    groupedByProgram.forEach { program ->
        println("==== Students of ${program.key} ====")
        var i = 1
        program.value.sortedBy { student -> student.yearLevel }
            .forEach { student ->
                println("${i++}. ${student.fName} ${student.lName} - Year Level ${student.yearLevel}")
            }
    }

}