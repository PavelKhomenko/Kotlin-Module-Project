package screens

import Utils
import Storage
import Note

internal class NoteCreate(
    override val storage: Storage,
    override var screen: String = "**** Создание заметки ****",
    override val options: MutableList<String> = mutableListOf()
) : AbstractScreen() {

    private var idArchive: Int? = null

    private var name: String? = null
    private var content: String? = null

    internal fun run(archiveId: Int) {
        this.idArchive = archiveId

        println(SEPARATOR)

        print("Введите имя заметки: ")
        name = Utils().validateString()
        updateData()

        print("Введите содержание заметки: ")
        content = Utils().validateString()
        updateData()

        options.add("Назад в Архив")

        options.forEachIndexed { index, option ->
            println("$index. $option")
        }
        println("Выберите пункт меню: ")

        validateCommand()
    }

    override fun validateCommand() {
        while (true) {
            when (Utils().validateInt(options.size - 1)) {
                0 -> {
                    updateStorage()
                    Archive(storage).run(idArchive!!)
                    break
                }
            }
        }
    }

    private fun updateStorage() {
        storage
            .getArchive(idArchive!!)
            .notes
            .add(
                Note(
                    name = this.name!!,
                    content = this.content!!
                )
            )
    }

    private fun updateData() {
        println(
            "Заголовок: $name \n" +
                    "Содержимое: $content"
        )
    }
}
