# Wagner-Fischer Spell Checker in Kotlin

## Overview

This Kotlin project implements a simple spell checker using the Wagner-Fischer algorithm. The spell checker provides suggestions for the closest words to a misspelled word based on a given dictionary.

## Usage

To use the spell checker, follow these steps:

1. Ensure Kotlin is installed on your machine.
2. Run the `main` function in your Kotlin project.

```kotlin
fun main() {
    val wordList = Utils.getStringsFromWordFile()
    val misspelledWord = "forsed"
    val suggestions = spellCheck(misspelledWord, wordList)
    println("Closest suggestions for $misspelledWord:")
    for ((suggestion, distance) in suggestions) {
        println("$suggestion ($distance)")
    }
}
``````

## How it Works

The spell checker utilizes the Wagner-Fischer algorithm, a dynamic programming approach to calculate the edit distance between two strings. It compares the input word to the words in the dictionary, providing a list of suggestions sorted by their edit distance.

## Example
Assuming a dictionary loaded from a file(In current project words.txt which contains 10k words), the example above would output suggestions for the misspelled word "forsed."

## Screenshot
<br>
    <img src="https://github.com/jaypatel208/Wagner-Fischer-Kotlin/assets/83394162/8f0c4583-76f9-4539-a126-8bbc92f2f862" alt="Algo success run" align="center" width="280" height="247">
<br>
