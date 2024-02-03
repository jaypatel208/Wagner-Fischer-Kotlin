import java.io.File

object Utils {
    fun getStringsFromWordFile(): List<String> {
        val fileName = "src/words.txt"
        val lines = mutableListOf<String>()

        File(fileName).forEachLine {
            lines.add(it)
        }
        return lines.toList()
    }
}