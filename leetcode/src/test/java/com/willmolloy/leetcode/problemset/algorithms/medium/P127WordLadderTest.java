package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P127WordLadderTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P127WordLadderTest {

  private final P127WordLadder fn = new P127WordLadder();

  @Test
  void example1() {
    assertThat(fn.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")))
        .isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(fn.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")))
        .isEqualTo(0);
  }

  @Test
  void wordListNotInChainOrder() {
    assertThat(fn.ladderLength("hot", "dog", List.of("hot", "dog", "dot"))).isEqualTo(3);
  }

  @Test
  void alreadyAtEnd() {
    assertThat(fn.ladderLength("a", "a", List.of())).isEqualTo(1);
  }

  @Test
  void oneChange() {
    assertThat(fn.ladderLength("a", "b", List.of("b"))).isEqualTo(2);
  }

  @Test
  void oneChangeButNotInWordList() {
    assertThat(fn.ladderLength("a", "b", List.of("c"))).isEqualTo(0);
  }
}
