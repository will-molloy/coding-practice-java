package com.willmolloy.projecteuler.common;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

/**
 * CollectionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class CollectionsTest {

  @Test
  void testSliding() {
    List<Integer> in = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    List<List<Integer>> expected =
        List.of(
            List.of(1, 2, 3),
            List.of(2, 3, 4),
            List.of(3, 4, 5),
            List.of(4, 5, 6),
            List.of(5, 6, 7),
            List.of(6, 7, 8),
            List.of(7, 8, 9),
            List.of(8, 9, 0));

    assertThat(Collections.sliding(in, 3)).isEqualTo(expected);
  }

  @Test
  void testTranspose() {
    List<List<Integer>> in = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
    List<List<Integer>> expected = List.of(List.of(1, 4, 7), List.of(2, 5, 8), List.of(3, 6, 9));

    assertThat(Collections.transpose(in)).isEqualTo(expected);
  }

  @Test
  void testGetDiagonalForwardSlopes() {
    List<List<Integer>> in = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
    List<List<Integer>> expected =
        List.of(List.of(1), List.of(4, 2), List.of(7, 5, 3), List.of(8, 6), List.of(9));

    assertThat(Collections.diagonalForwardSlopes(in)).isEqualTo(expected);
  }

  @Test
  void testGetDiagonalBackwardSlopes() {
    List<List<Integer>> in = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
    List<List<Integer>> expected =
        List.of(List.of(7), List.of(4, 8), List.of(1, 5, 9), List.of(2, 6), List.of(3));

    assertThat(Collections.diagonalBackwardSlopes(in)).isEqualTo(expected);
  }

  @Test
  void testZipWithIndex() {
    Stream<String> in = Stream.of("a", "b", "c");
    List<Pair<String, Integer>> expected =
        List.of(Pair.of("a", 0), Pair.of("b", 1), Pair.of("c", 2));

    assertThat(Collections.zipWithIndex(in).toList()).isEqualTo(expected);
  }

  @Test
  void testPermutations() {
    List<Integer> input = List.of(1, 2, 3);
    List<List<Integer>> expected =
        List.of(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1));

    assertThat(Collections.permutations(input).toList()).isEqualTo(expected);
  }
}
