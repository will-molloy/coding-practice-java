package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P905SortArrayByParityTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P905SortArrayByParityTest {

  @ParameterizedTest
  @MethodSource("p905")
  void example(P905SortArrayByParity p905) {
    assertThat(p905.sortArrayByParity(new int[] {3, 1, 2, 4}))
        .asList()
        .containsExactly(2, 4, 3, 1)
        .inOrder();
  }

  static Stream<P905SortArrayByParity> p905() {
    return Stream.of(new P905SortArrayByParity.Linear(), new P905SortArrayByParity.LinearInPlace());
  }
}
