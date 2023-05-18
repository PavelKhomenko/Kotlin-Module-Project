package screens


import Utils
import Storage


internal class Note(
    override val storage: Storage,
    override var screen: String = "**** Просмотр заметки ****",
    override val options: MutableList<String> = mutableListOf()
) : AbstractScreen() {

    private var idArchive: Int? = null
    private var idNote: Int? = null

    internal fun run(archiveId: Int, noteId: Int) {
        this.idArchive = archiveId
        this.idNote = noteId
        println(SEPARATOR)
        options.add("Назад")
        val note = storage.getArchive(idArchive!!).notes[idNote!!]
        println(screen)
        println(
            "Имя: ${note.name} \n" + "Содержимое: ${note.content}"
        )
        options.forEachIndexed { index, command ->
            println("$index. $command")
        }
        print("Введите пункт меню: ")
        validateCommand()
    }

    override fun validateCommand() {
        Utils().validateInt(options.size - 1)
        Archive(storage).run(idArchive!!)
    }
}