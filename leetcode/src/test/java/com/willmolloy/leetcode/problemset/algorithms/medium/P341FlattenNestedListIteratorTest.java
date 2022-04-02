package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;

import com.google.common.collect.Streams;
import com.willmolloy.leetcode.problemset.algorithms.medium.P341FlattenNestedListIterator.NestedInteger;
import com.willmolloy.leetcode.problemset.algorithms.medium.P341FlattenNestedListIterator.NestedIntegerImpl;
import com.willmolloy.leetcode.problemset.algorithms.medium.P341FlattenNestedListIterator.NestedIterator;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P341FlattenNestedListIteratorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P341FlattenNestedListIteratorTest {

  @Test
  void example1() {
    List<NestedInteger> nestedList =
        List.of(
            new NestedIntegerImpl(List.of(new NestedIntegerImpl(1), new NestedIntegerImpl(1))),
            new NestedIntegerImpl(2),
            new NestedIntegerImpl(List.of(new NestedIntegerImpl(1), new NestedIntegerImpl(1))));
    assertThat(nestedList.toString()).isEqualTo("[[1, 1], 2, [1, 1]]");

    NestedIterator nestedIterator = new NestedIterator(nestedList);

    assertThat(Streams.stream(nestedIterator)).containsExactly(1, 1, 2, 1, 1).inOrder();
  }

  @Test
  void example2() {
    List<NestedInteger> nestedList =
        List.of(
            new NestedIntegerImpl(1),
            new NestedIntegerImpl(
                List.of(
                    new NestedIntegerImpl(4),
                    new NestedIntegerImpl(List.of(new NestedIntegerImpl(6))))));
    assertThat(nestedList.toString()).isEqualTo("[1, [4, [6]]]");

    NestedIterator nestedIterator = new NestedIterator(nestedList);

    assertThat(Streams.stream(nestedIterator)).containsExactly(1, 4, 6).inOrder();
  }

  @Test
  void emptyList() {
    List<NestedInteger> nestedList = List.of();
    assertThat(nestedList.toString()).isEqualTo("[]");

    NestedIterator nestedIterator = new NestedIterator(nestedList);

    assertThat(Streams.stream(nestedIterator)).isEmpty();
  }

  @Test
  void emptyNestedList() {
    List<NestedInteger> nestedList = List.of(new NestedIntegerImpl(List.of()));
    assertThat(nestedList.toString()).isEqualTo("[[]]");

    NestedIterator nestedIterator = new NestedIterator(nestedList);

    assertThat(Streams.stream(nestedIterator)).isEmpty();
  }

  @Test
  void emptyNestedNestedList() {
    List<NestedInteger> nestedList =
        List.of(new NestedIntegerImpl(List.of(new NestedIntegerImpl(List.of()))));
    assertThat(nestedList.toString()).isEqualTo("[[[]]]");

    NestedIterator nestedIterator = new NestedIterator(nestedList);

    assertThat(Streams.stream(nestedIterator)).isEmpty();
  }
}
