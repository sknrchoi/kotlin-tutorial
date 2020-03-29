package example.myapp.generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

// class Aquarium<T>(val waterSupply: T)
class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) {"water supply needs processing first"}
        println("adding water from $waterSupply")
    }
}

fun genericsExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    // or
    // val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

   /*
    var aquarium2 = Aquarium("string")
    println(aquarium2.waterSupply)

    var aquarium3 = Aquarium(null)
    if (aquarium3.waterSupply == null) {
        println("water Supply is null")
    }
   */
    var aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
}

fun main() {
    genericsExample()
}