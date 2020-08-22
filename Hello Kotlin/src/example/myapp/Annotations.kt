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
}

fun main() {
    testAnnotations()
    labels()
}