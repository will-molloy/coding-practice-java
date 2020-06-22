package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-05. */
class P387FirstUniqueCharacterInAStringTest {

  private final P387FirstUniqueCharacterInAString p387 = new P387FirstUniqueCharacterInAString();

  @Test
  void example1() {
    assertThat(p387.firstUniqChar("leetcode")).isEqualTo(0);
  }

  @Test
  void example2() {
    assertThat(p387.firstUniqChar("loveleetcode")).isEqualTo(2);
  }
}
