package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.medium.P208ImplementTrie.Trie;
import org.junit.jupiter.api.Test;

/**
 * P208ImplementTrieTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P208ImplementTrieTest {

  @Test
  void example() {
    Trie trie = new Trie();
    trie.insert("apple");
    assertThat(trie.search("apple")).isTrue();
    assertThat(trie.search("app")).isFalse();
    assertThat(trie.startsWith("app")).isTrue();
    trie.insert("app");
    assertThat(trie.search("app")).isTrue();
  }
}
