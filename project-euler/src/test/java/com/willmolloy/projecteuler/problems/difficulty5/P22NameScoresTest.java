package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * P22NameScoresTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P22NameScoresTest {

  private final P22NameScores nameScores = new P22NameScores();

  @Test
  void singleName() {
    assertThat(nameScores.apply(List.of("COLIN"))).isEqualTo(53);
  }

  @Test
  void fromP022NamesTxtFile() throws IOException {
    List<String> names =
        Arrays.stream(
                Files.lines(Path.of("src/test/resources/problem_022/p022_names.txt"))
                    .collect(Collectors.joining())
                    // remove escape characters
                    .replace("\"", "")
                    // remove carriage returns
                    .replace("\r", "")
                    .split(","))
            .toList();
    assertThat(nameScores.apply(names)).isEqualTo(871_198_282);
  }
}
