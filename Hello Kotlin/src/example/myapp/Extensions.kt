package example.myapp

/*fun String.hasSpaces(): Boolean {
    val found = this.find {it == ' '}
    return found != null
}*/

fun String.hasSpaces() = find{it == ' '} != null

/*
// Extension functions only have access to the public API of the class they're extending.
class AquariumPlant(val color: String, private val size: Int)

fun AquariumPlant.isRed() = color == "red" // OK
fun AquariumPlant.isBig() = size > 50 // gives error
*/

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

// Add an extension property
val AquariumPlant.isGreen: Boolean
    get() = color == "green"

// nullable receivers
fun AquariumPlant?.pull() {
    // 'this' is not null by using '?.apply'
    this?.apply {
        println("removing $this")
    }
}