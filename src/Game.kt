fun main(args:Array<String>) {
    val name = "Magrigal"
    var healthPoints = 89
    val isBlassed = true
    val isImmortal = false
    val player = Player()
    player.castFireball()
    val auraColor = auraColor(isBlassed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlassed)
    printPlayerStatus(auraColor, isBlassed, name, healthStatus)

}

private fun printPlayerStatus(
    auraColor: String,
    isBlassed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlassed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlassed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlassed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}


private fun formatHealthStatus(healthPoints: Int, isBlassed: Boolean) = when (healthPoints) {
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
