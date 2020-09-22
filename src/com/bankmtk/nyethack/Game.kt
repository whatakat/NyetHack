package com.bankmtk.nyethack

fun main(args:Array<String>) {
    val player = Player()
    player.castFireball()
    val auraColor = player.auraColor()

    printPlayerStatus(player)

    player.auraColor()

}

private fun printPlayerStatus(player: Player){
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlassed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}






