package screens

import Utils
import Storage
import Archive


internal class ArchiveCreate(
    override val storage: Storage,
    override var screen: String = "*** Создание нового архива ***",
    override val options: MutableList<String> = mutableListOf()
) : AbstractScreen() {


    private lateinit var name: String

    internal fun run() {
        println(SEPARATOR)
        println(screen)
        print("Введите имя архива: ")

        validateCommand()

        storage.addArchive(Archive(name = this.name, mutableListOf()))
        ArchiveSelect(storage).run()
    }

    override fun validateCommand() {
        name = Utils().validateString()
    }
}