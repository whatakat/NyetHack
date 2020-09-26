package com.bankmtk.nyethack

import java.io.File

class Player(_name: String,
var healthPoints: Int=100,
var isBlassed: Boolean,
private val isImmortal: Boolean){
    var name = _name
    get() = "$field of $hometown"
    set(value) {
        field = value.trim()
    }
    val hometown: String = selectHomeTown()
    private fun selectHomeTown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
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
}