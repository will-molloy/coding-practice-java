package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Chars;
import org.junit.jupiter.api.Test;

/**
 * P443StringCompressionTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P443StringCompressionTest {

  private final P443StringCompression p443 = new P443StringCompression();

  @Test
  void example1() {
    char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    assertThat(p443.compress(chars)).isEqualTo(6);
    assertThat(Chars.asList(chars).subList(0, 6))
        .containsExactly('a', '2', 'b', '2', 'c', '3')
        .inOrder();
  }

  @Test
  void example2() {
    char[] chars = {'a'};
    assertThat(p443.compress(chars)).isEqualTo(1);
    assertThat(Chars.asList(chars).subList(0, 1)).containsExactly('a').inOrder();
  }

  @Test
  void example3() {
    char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    assertThat(p443.compress(chars)).isEqualTo(4);
    assertThat(Chars.asList(chars).subList(0, 4)).containsExactly('a', 'b', '1', '2').inOrder();
  }

  @Test
  void maintainRelativeOrder() {
    char[] chars = {'a', 'a', 'b', 'b', 'a', 'a'};
    assertThat(p443.compress(chars)).isEqualTo(6);
    assertThat(Chars.asList(chars).subList(0, 6))
        .containsExactly('a', '2', 'b', '2', 'a', '2')
        .inOrder();
  }

  @Test
  void endSingleChar() {
    char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd'};
    assertThat(p443.compress(chars)).isEqualTo(7);
    assertThat(Chars.asList(chars).subList(0, 7))
        .containsExactly('a', '2', 'b', '2', 'c', '3', 'd')
        .inOrder();
  }
}
