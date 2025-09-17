package com.willmolloy.adventofcode.common;

import static com.google.common.base.Preconditions.checkNotNull;

import com.willmolloy.adventofcode.common.grid.CharGrid;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * File based {@link Input}. Place the files under {@code resources/}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class FileInput implements Input {

  static FileInput example(Day day) {
    String fileName = fileName(day, "example_input");
    return getInput(fileName)
        .orElseThrow(() -> new IllegalArgumentException("File not found: " + fileName));
  }

  static Optional<FileInput> real(Day day) {
    String fileName = fileName(day, "real_input");
    return getInput(fileName);
  }

  private static String fileName(Day day, String inputDir) {
    return "input/%d/%s/day%d.txt".formatted(day.year(), inputDir, day.day());
  }

  private static Optional<FileInput> getInput(String fileName) {
    URL resource = FileInput.class.getClassLoader().getResource(fileName);
    if (resource == null) {
      return Optional.empty();
    }
    try {
      return Optional.of(new FileInput(Path.of(resource.toURI())));
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  private final Path path;

  private FileInput(Path path) {
    this.path = checkNotNull(path);
  }

  // Don't want to expose Stream on public methods, otherwise file potentially hit multiple times
  private Stream<String> stream() {
    try {
      return Files.lines(path);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  @Override
  public List<String> lines() {
    return stream().toList();
  }

  @Override
  public List<long[]> numLines() {
    return stream().map(line -> parseNums(line).toArray()).toList();
  }

  @Override
  public String string() {
    // join string WITHOUT newlines...!
    return stream().collect(Collectors.joining(""));
  }

  @Override
  public long[] nums() {
    return stream().flatMapToLong(FileInput::parseNums).toArray();
  }

  @Override
  public CharGrid charGrid() {
    return new CharGrid(stream().map(String::toCharArray).toArray(char[][]::new));
  }

  private static LongStream parseNums(String line) {
    return Arrays.stream(line.split("\\s+")).mapToLong(Long::parseLong);
  }
}
