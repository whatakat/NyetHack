package com.bankmtk.nyethack

fun main(args:Array<String>) {
    Game.play()
}

object Game{
    val player = Player("Madrigal")
    var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )
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
            println(GameInput(readLine()).processCommand())
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

        fun processCommand() = when (command.toLowerCase()){
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"

    }
    private fun move(directionInput: String) =
        try {
            val direction =  Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBonds){
                throw IllegalStateException("$direction is out of bounds.")
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception){
            "Invalid direction: $directionInput."
        }
}





