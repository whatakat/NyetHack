package com.bankmtk.nyethack

class Player(_name: String,
var healthPoints: Int,
var isBlassed: Boolean,
private val isImmortal: Boolean){
    var name = _name
    get() = field.capitalize()
    set(value) {
        field = value.trim()
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