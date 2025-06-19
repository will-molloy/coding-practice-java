package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P126WordLadder2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P126WordLadder2Test {

  @ParameterizedTest
  @MethodSource("fns")
  void example1(P126WordLadder2 fn) {
    assertThat(fn.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")))
        .containsExactly(
            List.of("hit", "hot", "dot", "dog", "cog"), List.of("hit", "hot", "lot", "log", "cog"));
  }

  @ParameterizedTest
  @MethodSource("fns")
  void example2(P126WordLadder2 fn) {
    assertThat(fn.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("fns")
  void alreadyAtEnd(P126WordLadder2 fn) {
    assertThat(fn.findLadders("a", "a", List.of())).containsExactly(List.of("a"));
  }

  static Stream<P126WordLadder2> fns() {
    return Stream.of(new P126WordLadder2.Dfs(), new P126WordLadder2.Bfs());
  }
}
