package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1519NumberOfNodesInTheSubTreeWithTheSameLabelTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1519NumberOfNodesInTheSubTreeWithTheSameLabelTest {

  private final P1519NumberOfNodesInTheSubTreeWithTheSameLabel p1519 =
      new P1519NumberOfNodesInTheSubTreeWithTheSameLabel();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[][] edges, String labels, List<Integer> expected) {
    assertThat(p1519.countSubTrees(n, edges, labels))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            7,
            new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
            "abaedcd",
            ImmutableList.of(2, 1, 1, 1, 1, 1, 1)),
        Arguments.of(4, new int[][] {{0, 1}, {1, 2}, {0, 3}}, "bbbb", ImmutableList.of(4, 2, 1, 1)),
        Arguments.of(
            5,
            new int[][] {{0, 1}, {0, 2}, {1, 3}, {0, 4}},
            "aabab",
            ImmutableList.of(3, 2, 1, 1, 1)),
        Arguments.of(
            6,
            new int[][] {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}},
            "cbabaa",
            ImmutableList.of(1, 2, 1, 1, 2, 1)),
        Arguments.of(
            7,
            new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}},
            "aaabaaa",
            ImmutableList.of(6, 5, 4, 1, 3, 2, 1)));
  }

  @Test
  void edgesAreUndirectedTreeIsRootedAt0() {
    assertThat(p1519.countSubTrees(4, new int[][] {{0, 2}, {0, 3}, {1, 2}}, "aeed"))
        .asList()
        .containsExactly(1, 1, 2, 1)
        .inOrder();
  }
}
