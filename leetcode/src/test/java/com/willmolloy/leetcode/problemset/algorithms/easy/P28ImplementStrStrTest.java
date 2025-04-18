package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P28ImplementStrStrTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P28ImplementStrStrTest {

  private final P28ImplementStrStr fun = new P28ImplementStrStr();

  @Test
  void example1() {
    assertThat(fun.strStr("hello", "ll")).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(fun.strStr("aaaaa", "bba")).isEqualTo(-1);
  }

  @Test
  void startsToMatchButDoesntButMatchesLater() {
    assertThat(fun.strStr("bbqbabba", "bba")).isEqualTo(5);
  }

  @Test
  void matchesMultipleTimesShouldReturnFirstOccurrence() {
    assertThat(fun.strStr("abcdefabcdef", "def")).isEqualTo(3);
  }

  @Test
  void startsToMatchAtEndButDoesnt() {
    assertThat(fun.strStr("aaabb", "bba")).isEqualTo(-1);
  }
}
