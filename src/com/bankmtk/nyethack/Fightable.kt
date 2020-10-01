package com.bankmtk.nyethack

interface Fightable {
    var healthPoints: Int
    var diceCount: Int
    val diceSides: Int
    val damageRoll: Int

    fun attack(opponent: Fightable):Int
}