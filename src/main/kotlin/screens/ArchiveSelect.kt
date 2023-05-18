package screens


import Storage
import Utils

internal class ArchiveSelect(
    override var storage: Storage?,
    override var screen: String = "**** Экран архивов ****",
    override val options: MutableList<String> = mutableListOf()
) : AbstractScreen() {


    internal fun run() {
        if (storage == null) {
            this.storage = Storage()
        }
        println(SEPARATOR)

        options.add("Создать архив")
        storage!!.getArchiveTitles().forEach { archiveTittle ->
            options.add(archiveTittle)
        }
        options.add("Выход")

        menuBuilder()

        validateCommand()
    }

    override fun validateCommand() {
        when (val command = Utils().validateInt(options.size - 1)) {
            0 -> ArchiveCreate(storage!!).run()
            options.size - 1 -> {
                println(SEPARATOR)
                println("Всего хорошего! До скорых встреч!")
            }

            else -> Archive(storage!!).run(command - 1)
        }
    }
}
