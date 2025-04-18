package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P676ImplementMagicDictionaryTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P676ImplementMagicDictionaryTest {

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
