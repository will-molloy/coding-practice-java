package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-23. */
class P676ImplementMagicDictionaryTest {

  private final P676ImplementMagicDictionary p676 = new P676ImplementMagicDictionary();

  @Test
  void example1() {
    p676.buildDict(new String[] {"hello", "leetcode"});
    assertThat(p676.search("hello")).isFalse();
    assertThat(p676.search("hhllo")).isTrue();
    assertThat(p676.search("hell")).isFalse();
    assertThat(p676.search("leetcoded")).isFalse();
  }
}
