import screens.ArchiveSelect
import java.util.*

fun main() {
    println(Calendar.getInstance().time)
    println("Добро пожаловать в приложение создания заметок!")
    ArchiveSelect(null).run()
}