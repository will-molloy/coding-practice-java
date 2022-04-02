package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.hard.P1032StreamOfCharacters.StreamChecker;
import org.junit.jupiter.api.Test;

/**
 * P1032StreamOfCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1032StreamOfCharactersTest {

  @Test
  void example() {
    StreamChecker streamChecker = new StreamChecker(new String[] {"cd", "f", "kl"});
    assertThat(streamChecker.query('a')).isFalse();
    assertThat(streamChecker.query('b')).isFalse();
    assertThat(streamChecker.query('c')).isFalse();
    assertThat(streamChecker.query('d')).isTrue(); // "cd"
    assertThat(streamChecker.query('e')).isFalse();
    assertThat(streamChecker.query('f')).isTrue(); // "f"
    assertThat(streamChecker.query('g')).isFalse();
    assertThat(streamChecker.query('h')).isFalse();
    assertThat(streamChecker.query('i')).isFalse();
    assertThat(streamChecker.query('j')).isFalse();
    assertThat(streamChecker.query('k')).isFalse();
    assertThat(streamChecker.query('l')).isTrue(); // "kl"
  }

  @Test
  void gapInWord() {
    StreamChecker streamChecker = new StreamChecker(new String[] {"abc"});
    assertThat(streamChecker.query('a')).isFalse();
    assertThat(streamChecker.query('b')).isFalse();
    assertThat(streamChecker.query('x')).isFalse();
    assertThat(streamChecker.query('c')).isFalse();
  }
}
