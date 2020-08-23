package example.myapp

import kotlin.reflect.full.*

/**
 * annotations
 */
annotation class ImAplant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAplant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false

    fun trim(){}
    fun fertilize(){}
}

fun testAnnotations() {
    val plantObject = Plant::class
    println("===== class object =====");
    for (m in plantObject.declaredMemberFunctions) {
        println(m.name)
    }
    println("===== annotation =====");
    for (a in plantObject.annotations){
        println(a.annotationClass.simpleName)
    }
    println("===== find a specific annotation =====");
    val myAnnotationObject = plantObject.findAnnotation<ImAplant>()
    println(myAnnotationObject)
}

/**
 * labeled breaks
 */
fun labels() {
    println("===== labeled breaks =====");
    outerLoop@ for(i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) break@outerLoop // breaks to outher loop
        }
    }
    println()
}

/**
 * lambda with argument
 */
fun lambdas() {
    println("===== lambdas =====")
    val waterFilter = {dirty: Int -> dirty / 2}
    println(waterFilter(30))

    data class Fish(val name: String)
    val myFish = listOf(Fish("Filipper"), Fish("Moby Dick"), Fish("Dory"))
    println(myFish.filter{it.name.contains("i")})
    println(myFish.filter{it.name.contains("i")}.joinToString(", "){it.name})
}


fun main() {
    testAnnotations()
    labels()
    lambdas()
}