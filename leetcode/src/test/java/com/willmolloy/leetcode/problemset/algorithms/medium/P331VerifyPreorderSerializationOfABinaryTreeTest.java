package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P331VerifyPreorderSerializationOfABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P331VerifyPreorderSerializationOfABinaryTreeTest {

  private final P331VerifyPreorderSerializationOfABinaryTree
      p331VerifyPreorderSerializationOfABinaryTree =
          new P331VerifyPreorderSerializationOfABinaryTree();

  @ParameterizedTest
  @MethodSource
  void examples(String preorder, boolean expected) {
    assertThat(p331VerifyPreorderSerializationOfABinaryTree.isValidSerialization(preorder))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
        Arguments.of("1,#", false),
        Arguments.of("9,#,#,1", false));
  }
}
