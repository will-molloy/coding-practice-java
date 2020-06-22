package com.wilmol.projecteuler.common;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

/** Created by Will on 17/03/2019. */
class CollectionsTest {

  @Test
  void testSliding() {
    List<Integer> in = ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    List<List<Integer>> expected =
        ImmutableList.of(
            ImmutableList.of(1, 2, 3),
            ImmutableList.of(2, 3, 4),
            ImmutableList.of(3, 4, 5),
            ImmutableList.of(4, 5, 6),
            ImmutableList.of(5, 6, 7),
            ImmutableList.of(6, 7, 8),
            ImmutableList.of(7, 8, 9),
            ImmutableList.of(8, 9, 0));

    assertThat(Collections.sliding(in, 3)).isEqualTo(expected);
  }

  @Test
  void testTranspose() {
    List<List<Integer>> in =
        ImmutableList.of(
            ImmutableList.of(1, 2, 3), ImmutableList.of(4, 5, 6), ImmutableList.of(7, 8, 9));
    List<List<Integer>> expected =
        ImmutableList.of(
            ImmutableList.of(1, 4, 7), ImmutableList.of(2, 5, 8), ImmutableList.of(3, 6, 9));

    assertThat(Collections.transpose(in)).isEqualTo(expected);
  }

  @Test
  void testGetDiagonalForwardSlopes() {
    List<List<Integer>> in =
        ImmutableList.of(
            ImmutableList.of(1, 2, 3), ImmutableList.of(4, 5, 6), ImmutableList.of(7, 8, 9));
    List<List<Integer>> expected =
        ImmutableList.of(
            ImmutableList.of(1),
            ImmutableList.of(4, 2),
            ImmutableList.of(7, 5, 3),
            ImmutableList.of(8, 6),
            ImmutableList.of(9));

    assertThat(Collections.diagonalForwardSlopes(in)).isEqualTo(expected);
  }

  @Test
  void testGetDiagonalBackwardSlopes() {
    List<List<Integer>> in =
        ImmutableList.of(
            ImmutableList.of(1, 2, 3), ImmutableList.of(4, 5, 6), ImmutableList.of(7, 8, 9));
    List<List<Integer>> expected =
        ImmutableList.of(
            ImmutableList.of(7),
            ImmutableList.of(4, 8),
            ImmutableList.of(1, 5, 9),
            ImmutableList.of(2, 6),
            ImmutableList.of(3));

    assertThat(Collections.diagonalBackwardSlopes(in)).isEqualTo(expected);
  }

  @Test
  void testZipWithIndex() {
    Stream<String> in = Stream.of("a", "b", "c");
    List<Pair<String, Integer>> expected =
        ImmutableList.of(Pair.of("a", 0), Pair.of("b", 1), Pair.of("c", 2));

    assertThat(Collections.zipWithIndex(in).collect(ImmutableList.toImmutableList()))
        .isEqualTo(expected);
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

    assertThat(Collections.permutations(input).collect(ImmutableList.toImmutableList()))
        .isEqualTo(expected);
  }
}
