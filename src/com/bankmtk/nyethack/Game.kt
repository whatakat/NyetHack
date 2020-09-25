package com.bankmtk.nyethack

fun main(args:Array<String>) {
    val player = Player("Kar")
    player.castFireball()

    var currentRoom = Room("Foyer")
    println(currentRoom.descroption())
    println(currentRoom.load())

    printPlayerStatus(player)

    player.auraColor()

}

private fun printPlayerStatus(player: Player){
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlassed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}






