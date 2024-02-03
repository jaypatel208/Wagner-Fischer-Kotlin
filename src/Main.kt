fun main() {
    val wordList = Utils.getStringsFromWordFile()
    val misspelledWord = "forsed"
    val suggestions = spellCheck(misspelledWord, wordList)
    println("Closest suggestions for $misspelledWord:")
    for ((suggestion, distance) in suggestions) {
        println("$suggestion ($distance)")
    }

}

fun spellCheck(word: String, dictionary: List<String>): List<Pair<String, Int>> {
    val suggestions = mutableListOf<Pair<String, Int>>()

    for (correctWord in dictionary) {
        val distance = wagnerFischer(word, correctWord)
        suggestions.add(correctWord to distance)
    }

    suggestions.sortWith { p1, p2 -> p1.second.compareTo(p2.second) }
    return suggestions.take(10)
}

fun wagnerFischer(s1: String, s2: String): Int {
    val lenS1 = s1.length
    val lenS2 = s2.length

    if (lenS1 > lenS2) {
        return wagnerFischer(s2, s1)
    }

    var currentRow = IntArray(lenS1 + 1) { it }

    for (i in 1..lenS2) {
        val previousRow = currentRow
        currentRow = IntArray(lenS1 + 1) { i }

        for (j in 1..lenS1) {
            val add = previousRow[j] + 1
            val delete = currentRow[j - 1] + 1
            val change = previousRow[j - 1] + if (s1[j - 1] != s2[i - 1]) 1 else 0
            currentRow[j] = minOf(add, delete, change)
        }
    }
    return currentRow[lenS1]
}