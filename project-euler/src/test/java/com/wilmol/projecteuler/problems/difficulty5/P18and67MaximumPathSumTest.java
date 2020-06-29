package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * P18and67MaximumPathSumTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P18and67MaximumPathSumTest {

  private final P18and67MaximumPathSum maximumPathSum = new P18and67MaximumPathSum();

  @Test
  void smallTriangle() {
    assertThat(
            maximumPathSum.apply(
                ImmutableList.of(
                    ImmutableList.of(3),
                    ImmutableList.of(7, 4),
                    ImmutableList.of(2, 4, 6),
                    ImmutableList.of(8, 5, 9, 3))))
        .isEqualTo(23);
  }

  private List<List<Integer>> parseTriangle(String triangle) {
    return Arrays.stream(triangle.split("\n"))
        .map(
            s ->
                Arrays.stream(s.split(" "))
                    .map(Integer::valueOf)
                    .collect(ImmutableList.toImmutableList()))
        .collect(ImmutableList.toImmutableList());
  }

  @Test
  void p18Triangle() {
    String string =
        ""
            + "75\n"
            + "95 64\n"
            + "17 47 82\n"
            + "18 35 87 10\n"
            + "20 04 82 47 65\n"
            + "19 01 23 75 03 34\n"
            + "88 02 77 73 07 63 67\n"
            + "99 65 04 28 06 16 70 92\n"
            + "41 41 26 56 83 40 80 70 33\n"
            + "41 48 72 33 47 32 37 16 94 29\n"
            + "53 71 44 65 25 43 91 52 97 51 14\n"
            + "70 11 33 28 77 73 17 78 39 68 17 57\n"
            + "91 71 52 38 17 14 91 43 58 50 27 29 48\n"
            + "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n"
            + "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
    assertThat(maximumPathSum.apply(parseTriangle(string))).isEqualTo(1074);
  }

  @Test
  void p67Triangle() throws IOException {
    String string =
        Files.lines(Path.of("src/test/resources/problem_067/p067_triangle.txt"))
            .collect(Collectors.joining("\n"));
    assertThat(maximumPathSum.apply(parseTriangle(string))).isEqualTo(7273);
  }
}
