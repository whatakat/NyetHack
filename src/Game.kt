fun main(args:Array<String>) {
    val name = "Magrigal"
    var healthPoints = 89
    val isBlassed = true
    val isImmortal = false
    val auraVisible = isBlassed&&healthPoints>50||isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatus = formatHealthStatus(healthPoints, isBlassed)
    println("(Aura: $auraColor) "+ "(Blessed: ${if (isBlassed) "YES" else "NO"})")
    println("$name $healthStatus")

}

private fun formatHealthStatus(healthPoints: Int, isBlassed: Boolean): String {
    val healthStatus = when (healthPoints) {
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
    return healthStatus
}