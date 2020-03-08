package example.myapp.decor

data class Decoration(val rocks: String) {
}

data class Decoration2(val rocks: String, val wood: String, val diver: String) {
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println("-------structural equality-------")
    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))

    println(decoration1 == decoration2)
    println(decoration3 == decoration2)

    println("-------referential equality-------")
    println(decoration1 === decoration2)
    println(decoration3 === decoration2)

    println("-------data class 3 properties-------")
    val decoration4 = Decoration2("crystal", "wood", "diver")
    println(decoration4)

    // Assign all properties to variables
    /*val (rock, wood, diver) = decoration4
    println(rock)
    println(wood)
    println(diver)*/

    // Skip properties by using _
    val (rock, _, diver) = decoration4
    println(rock)
    println(diver)
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUD(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}