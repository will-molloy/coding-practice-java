package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-03-10. */
class P126WordLadder2Test {

  @ParameterizedTest
  @MethodSource("fns")
  void example1(P126WordLadder2 fn) {
    assertThat(
            fn.findLadders(
                "hit", "cog", ImmutableList.of("hot", "dot", "dog", "lot", "log", "cog")))
        .containsExactly(
            ImmutableList.of("hit", "hot", "dot", "dog", "cog"),
            ImmutableList.of("hit", "hot", "lot", "log", "cog"));
  }

  @ParameterizedTest
  @MethodSource("fns")
  void example2(P126WordLadder2 fn) {
    assertThat(fn.findLadders("hit", "cog", ImmutableList.of("hot", "dot", "dog", "lot", "log")))
        .isEmpty();
  }

  @ParameterizedTest
  @MethodSource("fns")
  void alreadyAtEnd(P126WordLadder2 fn) {
    assertThat(fn.findLadders("a", "a", ImmutableList.of())).containsExactly(ImmutableList.of("a"));
  }

  static Stream<P126WordLadder2> fns() {
    return Stream.of(new P126WordLadder2.Dfs(), new P126WordLadder2.Bfs());
  }
}
