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
    fun example(day: Day): FileInput {
      val fileName = fileName(day, "example_input")
      return requireNotNull(getInput(fileName)) { "File not found: $fileName" }
    }

    @JvmStatic
    fun real(day: Day): FileInput? {
      val fileName = fileName(day, "real_input")
      return getInput(fileName)
    }

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

  override fun lines(): List<String> = path.readLines()

  override fun numLines(): List<LongArray> = lines().map { parseNums(it).toLongArray() }

  // join string WITHOUT newlines...!
  override fun string(): String = lines().joinToString("")

  override fun nums(): LongArray = lines().flatMap(::parseNums).toLongArray()

  override fun charGrid(): CharGrid {
    val array = lines().map { it.toCharArray() }.toTypedArray()
    return CharGrid(array)
  }

  private fun parseNums(line: String): List<Long> = line.split("\\s+".toRegex()).map { it.toLong() }
}
