class Player{
    var name = "madrigal"
    get() = field.capitalize()
    set(value) {
        field = value.trim()
    }
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
}