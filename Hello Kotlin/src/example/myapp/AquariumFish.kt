package example.myapp

interface FishColor {
    val color: String
}

interface FishAction {
    fun eat()
}

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

class Shark
    : FishAction by PrintingFishAction("hunt and eat fish"),
      FishColor {
    override val color = "gray"
}

class Plecostomus(fishColor: FishColor = GoldColor)
    : FishColor by fishColor,
      FishAction by PrintingFishAction("eat algae") {

}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
