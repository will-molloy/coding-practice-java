package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P211AddAndSearchWordDataStructureDesign.WordDictionary;
import org.junit.jupiter.api.Test;

/**
 * P211AddAndSearchWordDataStructureDesignTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P211AddAndSearchWordDataStructureDesignTest {

  @Test
  void example() {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    assertThat(wordDictionary.search("pad")).isFalse();
    assertThat(wordDictionary.search("bad")).isTrue();
    assertThat(wordDictionary.search(".ad")).isTrue();
    assertThat(wordDictionary.search("b..")).isTrue();

    assertThat(wordDictionary.search("bh.")).isFalse();
    assertThat(wordDictionary.search("b...")).isFalse();
    assertThat(wordDictionary.search("...")).isTrue();
  }
}
