package screens

import Utils
import Storage
import Archive


internal class Archive(
    override var storage: Storage,
    override var screen: String = "**** Заметки в архиве |%s| ****",
    override val options: MutableList<String> = mutableListOf()
) : AbstractScreen() {


    private var archive: Archive? = null
    private var idArchive: Int? = null


    internal fun run(archiveId: Int) {
        this.idArchive = archiveId
        this.archive = storage.getArchive(archiveId)

        println(SEPARATOR)
        screen = String.format(screen, archive!!.name)
        options.add("Создать заметку")
        archive!!.notes.forEach { note ->
            options.add(note.name)
        }
        options.add("Назад")

        menuBuilder()

        validateCommand()
    }

    override fun validateCommand() {
        when (val command = Utils().validateInt(options.size - 1)) {
            0 -> NoteCreate(storage).run(idArchive!!)
            options.size - 1 -> ArchiveSelect(storage).run()
            else -> Note(storage).run(idArchive!!, command - 1)
        }
    }
}
