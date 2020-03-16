package example.myapp

import example.myapp.decor.Direction
import example.myapp.decor.makeDecorations

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
    println("-------secondary constructors-------")
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()

    println("-------property setter-------")
    val aquarium7 = Aquarium(numberOfFish = 29)
    aquarium7.printSize()
    aquarium7.volume = 70
    aquarium7.printSize()

    println("-------subclasses and inheritance-------")
    val aquarium8 = Aquarium(length = 25, width = 25, height = 40)
    aquarium8.printSize()
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main() {
    //buildAquarium()
    //makeFish()
    makeDecorations()

    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

    println("Does it have spaces?".hasSpaces())

    // extension
    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()

    println(aquariumPlant.isGreen)

    val plant2: AquariumPlant? = null
    plant2.pull()
}