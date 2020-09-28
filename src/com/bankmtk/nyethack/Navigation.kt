package com.bankmtk.nyethack

data class Coordinate(val x: Int, val y: Int){
    val isInBonds = x >=0 && y >= 0 }