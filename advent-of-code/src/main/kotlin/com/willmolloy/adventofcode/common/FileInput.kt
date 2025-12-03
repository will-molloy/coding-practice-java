package com.willmolloy.adventofcode.common

import com.willmolloy.adventofcode.common.grid.CharGrid
import java.net.URISyntaxException
import java.nio.file.Path
import kotlin.io.path.readLines

/**
 * File based [Input]. Place the files under `resources/`.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
internal class FileInput private constructor(private val path: Path) : Input {

  companion object {
    @JvmStatic
    fun example(day: Day): FileInput = requireNotNull(getInput(fileName(day, "example_input")))

    @JvmStatic fun real(day: Day): FileInput? = getInput(fileName(day, "real_input"))

    private fun fileName(day: Day, inputDir: String) =
      "input/${day.year}/$inputDir/day${day.day}.txt"

    private fun getInput(fileName: String): FileInput? {
      val resource = FileInput::class.java.classLoader.getResource(fileName) ?: return null
      return try {
        FileInput(Path.of(resource.toURI()))
      } catch (e: URISyntaxException) {
        throw RuntimeException(e)
      }
    }
  }

  // join string WITHOUT newlines...!
  override fun readString(): String = readLines().joinToString("")

  override fun readLines(): List<String> = path.readLines()

  override fun readNums(): LongArray = readLines().flatMap(::parseNums).toLongArray()

  override fun readLinesOfNums(): List<LongArray> = readLines().map { parseNums(it).toLongArray() }

  override fun readLinesOfDigits(): List<IntArray> =
    readLines().map { parseDigits(it).toIntArray() }

  override fun readCharGrid(): CharGrid =
    CharGrid(readLines().map { it.toCharArray() }.toTypedArray())

  private fun parseNums(line: String): List<Long> = line.split(Regex("\\s+")).map { it.toLong() }

  private fun parseDigits(line: String): List<Int> = line.toCharArray().map { it.digitToInt() }
}
