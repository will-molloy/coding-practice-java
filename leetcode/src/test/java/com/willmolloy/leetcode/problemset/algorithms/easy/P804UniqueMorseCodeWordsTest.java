package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P804UniqueMorseCodeWordsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P804UniqueMorseCodeWordsTest {

  private final P804UniqueMorseCodeWords p804 = new P804UniqueMorseCodeWords();

  @Test
  void example() {
    assertThat(p804.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}))
        .isEqualTo(2);
  }
}
