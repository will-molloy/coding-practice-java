package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P844BackspaceStringCompareTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P844BackspaceStringCompareTest {

  private final P844BackspaceStringCompare fun = new P844BackspaceStringCompare();

  @Test
  void example1() {
    assertThat(fun.backspaceCompare("ab#c", "ad#c")).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.backspaceCompare("ab##", "c#d#")).isTrue();
  }

  @Test
  void example3() {
    assertThat(fun.backspaceCompare("a##c", "#a#c")).isTrue();
  }

  @Test
  void example4() {
    assertThat(fun.backspaceCompare("a#c", "b")).isFalse();
  }

  @Test
  void manyBackspaceAtEnd() {
    assertThat(fun.backspaceCompare("a###", "b###")).isTrue();
  }

  @Test
  void manyBackspaceAtStart() {
    assertThat(fun.backspaceCompare("###a", "###b")).isFalse();
  }

  @Test
  void oneIsErasedOtherIsnt() {
    assertThat(fun.backspaceCompare("a#", "b")).isFalse();
  }

  @Test
  void dontBackspaceBackspaceCharacter() {
    assertThat(fun.backspaceCompare("bxj##tw", "bxo#j##tw")).isTrue();
  }
}
