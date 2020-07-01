package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P212WordSearch2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P212WordSearch2Test {

  private final P212WordSearch2 p212 = new P212WordSearch2();

  @Test
  void example() {
    char[][] board = {
      {'o', 'a', 'a', 'n'},
      {'e', 't', 'a', 'e'},
      {'i', 'h', 'k', 'r'},
      {'i', 'f', 'l', 'v'},
    };
    assertThat(p212.findWords(board, new String[] {"oath", "pea", "eat", "rain"}))
        .containsExactly("eat", "oath");
  }

  @Test
  void cantReuseCharacters() {
    char[][] board = {{'a', 'a', 'a', 'a'}};
    assertThat(p212.findWords(board, new String[] {"a", "aaaa", "aaaaa"}))
        .containsExactly("a", "aaaa");
  }

  @Test
  void noWordsFound() {
    char[][] board = {{'a', 'a', 'a', 'a'}};
    assertThat(p212.findWords(board, new String[] {"b"})).isEmpty();
  }
}
