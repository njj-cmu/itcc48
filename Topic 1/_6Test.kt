/*
DATA CLASS Template of student

data class Student (
    val id: String,
    val firstName: String,
    val lastName: String,
    val grade: Double,
    val yearLevel: Int
)
 */

/*
    Regular Class for Student
 */
class Student(
    val id: String,
    val firstName: String,
    val lastName: String,
    val grade: Double,
    val yearLevel: Int
) {
    // Functions inside the Student
    fun hasPassed(): Boolean {
        return grade in 1.0..3.0
    }

    fun isHonor(): Boolean {
        return grade in 1.0..1.75
    }

    fun introduce() {
        println("I am $firstName $lastName, with a grade of $grade, and year level of $yearLevel.")
    }
}


fun main() {

    val claire = Student("20218301006", "Claire", "Obscur", 2.75, 1)
    val jd = Student("2019200123", "John", "Doe", 5.00, 1)
    val random = Student("20218301006", "Jan", "Doe", 1.00, 1)
    val senior = Student("20218301007", "Senior", "Student", 4.00, 4)

    // Using object methods
    claire.introduce()
    println("Claire passed...? ${claire.hasPassed()}")
    println("Clair has honors...? ${claire.isHonor()}")

    // Creating a list of students
    val students: List<Student> = listOf(claire, jd, random, senior)

    // Creating an attendance of students
    // Create a Set first
    val attendance = setOf(claire, jd, random, senior)

    // Create a list based on the set for UI purposes...
    val orderedAttendance = attendance.sortedBy { student -> student.lastName }

    // Printing out elements inside orderedAttendance
    orderedAttendance.forEach { student -> println(student) }

    // Creating a map of the List<Student>
    val mapOfStudents = students.associateBy { student -> student.id }

    // Map -> List transformation
    val reverseMap = mapOfStudents.values.sortedBy { student -> student.lastName }
    println(reverseMap)
}