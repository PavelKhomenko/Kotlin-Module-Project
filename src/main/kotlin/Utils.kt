import java.util.*

open class Utils {

    private val scanner = Scanner(System.`in`)

    fun validateInt(optionMaxNumber: Int): Int {
        while (true) {
            val input = scanner.nextLine().toIntOrNull() ?: -1
            if (input > optionMaxNumber || input <= -1) {
                print("Число должно быть от 0 до $optionMaxNumber! Повторите ввод: ")
                continue
            }
            return input
        }
    }

    fun validateString(): String {
        while (true) {
            val input = scanner.nextLine().trimStart()
            if (input.isEmpty()) {
                print("Ввод не должен быть пустым. Повторите: ")
                continue
            }
            return input
        }
    }

}