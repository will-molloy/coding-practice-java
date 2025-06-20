package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.medium.P430FlattenAMultilevelDoublyLinkedList.Node;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P430FlattenAMultilevelDoublyLinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P430FlattenAMultilevelDoublyLinkedListTest {

  @ParameterizedTest
  @MethodSource("funcs")
  void example1(P430FlattenAMultilevelDoublyLinkedList func) {
    Node node =
        Node.multiLevel(
            List.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(null, null, 7, 8, 9, 10),
                Arrays.asList(null, 11, 12)));
    Node flattened = Node.singleLevel(List.of(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6));
    assertThat(func.flatten(node)).isEqualTo(flattened);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void example2(P430FlattenAMultilevelDoublyLinkedList func) {
    Node node = Node.multiLevel(List.of(Arrays.asList(1, 2), Arrays.asList(3)));
    Node flattened = Node.singleLevel(List.of(1, 3, 2));
    assertThat(func.flatten(node)).isEqualTo(flattened);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void allChildren(P430FlattenAMultilevelDoublyLinkedList func) {
    Node node =
        Node.multiLevel(
            List.of(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4),
                Arrays.asList(5)));
    Node flattened = Node.singleLevel(List.of(1, 2, 3, 4, 5));
    assertThat(func.flatten(node)).isEqualTo(flattened);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void noChildren(P430FlattenAMultilevelDoublyLinkedList func) {
    Node node = Node.multiLevel(List.of(Arrays.asList(1, 2, 3, 4, 5)));
    Node flattened = Node.singleLevel(List.of(1, 2, 3, 4, 5));
    assertThat(func.flatten(node)).isEqualTo(flattened);
  }

  static Stream<Arguments> funcs() {
    return Stream.of(
        Arguments.of(new P430FlattenAMultilevelDoublyLinkedList.Stack()),
        Arguments.of(new P430FlattenAMultilevelDoublyLinkedList.Recursion()));
  }
}
