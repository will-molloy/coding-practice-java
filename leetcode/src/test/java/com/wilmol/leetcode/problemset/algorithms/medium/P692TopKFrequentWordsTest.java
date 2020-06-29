package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P692TopKFrequentWordsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P692TopKFrequentWordsTest {

  private final P692TopKFrequentWords p692 = new P692TopKFrequentWords();

  @Test
  void example1() {
    assertThat(p692.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2))
        .containsExactly("i", "love")
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p692.topKFrequent(
                new String[] {
                  "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
                },
                4))
        .containsExactly("the", "is", "sunny", "day")
        .inOrder();
  }

  @Test
  void sameFreqTakeLowerAlphabeticalOrder() {
    assertThat(p692.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 1))
        .containsExactly("i");
  }

  @Test
  void encounterOrder() {
    assertThat(p692.topKFrequent(new String[] {"a", "aa", "aaa"}, 2))
        .containsExactly("a", "aa")
        .inOrder();
  }

  @Test
  void wtf() {
    assertThat(p692.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 3))
        .containsExactly("i", "love", "coding")
        .inOrder();
  }
}
