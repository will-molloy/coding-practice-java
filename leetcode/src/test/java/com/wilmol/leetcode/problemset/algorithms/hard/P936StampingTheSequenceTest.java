package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import org.junit.jupiter.api.Test;

/**
 * P936StampingTheSequenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P936StampingTheSequenceTest {

  private final P936StampingTheSequence p936StampingTheSequence = new P936StampingTheSequence();

  @Test
  void example1() {
    check("abc", "ababc");
  }

  @Test
  void example2() {
    check("abca", "aabcaca");
  }

  @Test
  void notPossible() {
    assertThat(p936StampingTheSequence.movesToStamp("abc", "xyz")).isEmpty();
  }

  private void check(String stamp, String target) {
    int[] moves = p936StampingTheSequence.movesToStamp(stamp, target);

    assertWithMessage("Result sequence not within 10 * target.length moves")
        .that(moves.length)
        .isLessThan(10 * target.length());

    char[] actual = new char[target.length()];
    for (int offset : moves) {
      for (int i = 0; i < stamp.length(); i++) {
        actual[i + offset] = stamp.charAt(i);
      }
    }
    assertThat(new String(actual)).isEqualTo(target);
  }
}
