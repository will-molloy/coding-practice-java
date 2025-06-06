package com.willmolloy.projecteuler.problems.difficulty10;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * P81PathSumTwoWaysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class P81PathSumTwoWaysTest {

  private static final int[][] MATRIX_5X5 = {
    {131, 673, 234, 103, 18},
    {201, 96, 342, 965, 150},
    {630, 803, 746, 422, 111},
    {537, 699, 497, 121, 956},
    {805, 732, 524, 37, 331}
  };

  private static final int[][] MATRIX_80X80;

  static {
    int[][] temp = null;
    try {
      temp =
          Files.lines(Path.of("src/test/resources/problem_081_082_083/p081_matrix.txt"))
              .map(line -> Arrays.stream(line.split(",")).mapToInt(Integer::valueOf).toArray())
              .toArray(int[][]::new);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      MATRIX_80X80 = temp;
    }
  }

  public static int[][] get5x5Matrix() {
    return deepCopy(MATRIX_5X5);
  }

  public static int[][] get80x80Matrix() {
    return deepCopy(MATRIX_80X80);
  }

  private static int[][] deepCopy(int[][] array) {
    return Arrays.stream(array).map(row -> row.clone()).toArray(i -> array.clone());
  }

  @Test
  void test5x5Matrix() {
    assertThat(P81PathSumTwoWays.shortestPath(MATRIX_5X5)).isEqualTo(2427);
  }

  @Test
  void test80x80Matrix() {
    assertThat(P81PathSumTwoWays.shortestPath(MATRIX_80X80)).isEqualTo(427_337);
  }
}
