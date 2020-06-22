package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-09. */
class P127WordLadderTest {

  private final P127WordLadder fn = new P127WordLadder();

  @Test
  void example1() {
    assertThat(
            fn.ladderLength(
                "hit", "cog", ImmutableList.of("hot", "dot", "dog", "lot", "log", "cog")))
        .isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(fn.ladderLength("hit", "cog", ImmutableList.of("hot", "dot", "dog", "lot", "log")))
        .isEqualTo(0);
  }

  @Test
  void wordListNotInChainOrder() {
    assertThat(fn.ladderLength("hot", "dog", ImmutableList.of("hot", "dog", "dot"))).isEqualTo(3);
  }

  @Test
  void alreadyAtEnd() {
    assertThat(fn.ladderLength("a", "a", ImmutableList.of())).isEqualTo(1);
  }

  @Test
  void oneChange() {
    assertThat(fn.ladderLength("a", "b", ImmutableList.of("b"))).isEqualTo(2);
  }

  @Test
  void oneChangeButNotInWordList() {
    assertThat(fn.ladderLength("a", "b", ImmutableList.of("c"))).isEqualTo(0);
  }
}
