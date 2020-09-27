package com.bankmtk.nyethack

fun main(args:Array<String>) {
    Game.play()
}

object Game{
    val player = Player("Madrigal")
    var currentRoom = TownSquare()
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }
    fun play(){
        while (true){
            println(currentRoom.descroption())
            println(currentRoom.load())

            printPlayerStatus(player)
            print("> Enter your command: ")
            println("Last command: ${readLine()}")
        }
    }
    private fun printPlayerStatus(player: Player){
        println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlassed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1,{ "" })

    }
}





