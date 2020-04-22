package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.problemset.algorithms.medium.P208ImplementTrie.Trie;

/** Created by wilmol on 2020-04-22. */
class P208ImplementTrieTest {

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
