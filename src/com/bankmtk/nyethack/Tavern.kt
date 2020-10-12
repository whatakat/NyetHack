package com.bankmtk.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc","Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt").readText().split("\n")
val patronGold = mutableMapOf<String, Double>()

private fun <T> Iterable<T>.random():T = this.shuffled().first()

fun main(args: Array<String>) {
    if (patronList.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards.")
    } else{
        println("The tavern master says: Eli isn't here.")
    }
    if (patronList.containsAll(listOf("Sophie","Mordoc"))){
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    }else{
        println("The tavern master says: Nay, they departed hour ago.")
    }
    //com.bankmtk.nyethack.placeOrder("shandy,Dragon's Breath,5.91")

    (0..9).forEach {
        val first = patronList.random()
        val last = lastName.random()
        val name ="$first $last"
        uniquePatrons +=name
    }
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
    var orderCount = 0
    while (orderCount<=9){
        placeOrder(
            uniquePatrons.random(),
            menuList.random()
        )
        orderCount++
    }
    displayPatronBalances()
}
private fun displayPatronBalances(){
    patronGold.forEach{ patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}
fun performPurchase(price: Double, patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")){
        when(it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(patronName: String, menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order")
    val(name,type,price)=menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble(), patronName)

    val phrase = if (name =="Dragon's Breath"){
        "$patronName exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "$patronName says: Thank for the $name."
    }
    println(phrase)

}