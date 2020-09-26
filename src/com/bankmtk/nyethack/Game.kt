package com.bankmtk.nyethack

fun main(args:Array<String>) {
    val player = Player("Karish")
    player.castFireball()

    var currentRoom = TownSquare()
    println(currentRoom.descroption())
    println(currentRoom.load())

    printPlayerStatus(player)

    player.auraColor()

}

private fun printPlayerStatus(player: Player){
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlassed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
object Game{
    init {
        println("Welcome, adventurer.")
    }
}





