data class Archive(val name: String, val notes: MutableList<Note>)

data class Note(val name: String, val content: String)

class Storage {
    private val storage = mutableListOf<Archive>()

    fun addArchive(archive: Archive) {
        storage.add(archive)
    }

    fun getArchiveTitles(): List<String> {
        return storage.map { it.name }
    }

    fun getArchive(id: Int): Archive {
        return storage[id]
    }


}