package com.bankmtk.nyethack

open class Room(val name: String){
    protected open val dangerLevel = 5
    var monster: Monster? = Goblin()
    fun descroption() = "Room: $name\n"+
            "Danger level: $dangerLevel\n"+
            "Creature: ${monster?.description ?: "none."}"
    open fun load() = "Nothing much to see here..."
}
class TownSquare : Room("Town Square"){
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound ="GWONG"
    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"
    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
fun Room.configurePitGoblin(block: Room.(Goblin)->Goblin): Room{
    val goblin = block(Goblin("Pit Goblin", description = "An Evil Pit Goblin"))
    monster = goblin
    return this
}