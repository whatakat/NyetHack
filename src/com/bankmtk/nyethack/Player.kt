package com.bankmtk.nyethack

import com.bankmtk.nyethack.extensions.random as randomizer
import java.io.File

class Player(_name: String,
override var healthPoints: Int=100,
var isBlassed: Boolean,
private var isImmortal: Boolean):Fightable{
    var name = _name
    get() = "${field.capitalize()} of $hometown"
    set(value) {
        field = value.trim()
    }
    val hometown by lazy { selectHomeTown() }
    var currentPosition = Coordinate(0,0)
    private fun selectHomeTown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .randomizer()
    init {
        require(healthPoints>0, {"healthPoints must be greater than zero."})
        require(name.isNotBlank(),{"Player must have a name."})
    }
    constructor(name: String):this(name,isBlassed = true,isImmortal = false){
        if (name.toLowerCase() == "kar") healthPoints = 40
    }


     fun auraColor(): String {
        val auraVisible = isBlassed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }
    fun formatHealthStatus() = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlassed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    override val diceCount: Int = 3

    override val diceSides: Int = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlassed){
            damageRoll*2
        }else {
            damageRoll
        }
        opponent.healthPoints -=damageDealt
        return damageDealt
    }
}