package example.myapp

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

fun main() {
    buildAquarium()
}