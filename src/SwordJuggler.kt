import java.lang.IllegalStateException

fun main(args: Array<String>) {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() ==3
    if (isJugglingProficient){
        swordJuggling = 2
    }
    proficiencyCheck(swordJuggling)
    swordJuggling = swordJuggling!!.plus(1)
    println("You juggle $swordJuggling swords!")

}
fun proficiencyCheck(swordsJuggling: Int?){
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
}