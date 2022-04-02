package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P96UniqueBinarySearchTreesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P96UniqueBinarySearchTreesTest {

  @ParameterizedTest
  @MethodSource("funs")
  void n1(P96UniqueBinarySearchTrees fun) {
    assertThat(fun.numTrees(1)).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n2(P96UniqueBinarySearchTrees fun) {
    assertThat(fun.numTrees(2)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n3(P96UniqueBinarySearchTrees fun) {
    assertThat(fun.numTrees(3)).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n4(P96UniqueBinarySearchTrees fun) {
    assertThat(fun.numTrees(4)).isEqualTo(14);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n5(P96UniqueBinarySearchTrees fun) {
    assertThat(fun.numTrees(5)).isEqualTo(42);
  }

  static Stream<P96UniqueBinarySearchTrees> funs() {
    return Stream.of(
        new P96UniqueBinarySearchTrees.TopDownRecursive(),
        new P96UniqueBinarySearchTrees.BottomUpIterative());
  }
}
