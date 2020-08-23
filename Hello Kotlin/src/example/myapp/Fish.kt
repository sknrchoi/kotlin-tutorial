package example.myapp

import sun.plugin2.message.JavaScriptBaseMessage

data class Fish (var name: String)

fun fishExamples() {
    val fish = Fish("splashy")

    myWith (fish.name) {
    //with (fish.name) {
       println( "with() ->" + this.capitalize())
    }

    // run() returns property
    fish.run {
        name
    }

    // apply() returns changed object
    var fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
    println("apply() -> " + fish2.name)

    // let() returns a copy of the object with the changes
    println("let() -> " + fish.let {it.name.capitalize()}
        .let{it + "fish"} // Splashyfish
        .let{it.length} // 11
        .let{it + 31})
    println(fish) // it hasn't changed.

}

/**
 * with()
 */
fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

/**
 * Single Abstract Methods(SAM)
 */
fun runExample() {
    // SAM
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)

    // use lambda
    JavaRun.runNow({
        println("Passing a lambda as a Runnable")
    })

    // use last parameter call syntax
    JavaRun.runNow {
        println("Last parameter is a lambda as a Runnable")
    }
}
fun main() {
    fishExamples()
    runExample()
}