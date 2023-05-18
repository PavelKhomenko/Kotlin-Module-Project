package screens

import Storage

internal const val SEPARATOR = "-----------------"

abstract class AbstractScreen {
    abstract val storage: Storage?
    abstract var screen: String
    abstract val options: MutableList<String>

    abstract fun validateCommand()

    internal fun menuBuilder() {
        println(screen)
        options.forEachIndexed { index, option ->
            println("$index. $option")
        }
        println("Choose your path, Jedi!")
    }
}