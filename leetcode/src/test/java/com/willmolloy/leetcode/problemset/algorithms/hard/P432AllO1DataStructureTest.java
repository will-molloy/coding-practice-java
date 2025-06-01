package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link P432AllO1DataStructure}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P432AllO1DataStructureTest {

  static Stream<P432AllO1DataStructure> solutions() {
    return Stream.of(
        new P432AllO1DataStructure.CustomLinkedList(),
        new P432AllO1DataStructure.BuiltInSortedMap());
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example1(P432AllO1DataStructure allOne) {
    allOne.inc("hello");
    allOne.inc("hello");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    assertThat(allOne.getMinKey()).isEqualTo("hello");
    allOne.inc("leet");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    assertThat(allOne.getMinKey()).isEqualTo("leet");
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void testEmpty(P432AllO1DataStructure allOne) {
    assertThat(allOne.getMaxKey()).isEmpty();
    assertThat(allOne.getMinKey()).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void testDecreaseNoEntryStaysEmpty(P432AllO1DataStructure allOne) {
    allOne.dec("hello");
    assertThat(allOne.getMaxKey()).isEmpty();
    assertThat(allOne.getMinKey()).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void testDecreaseRemovesEntry(P432AllO1DataStructure allOne) {
    allOne.inc("hello");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    allOne.dec("hello");
    assertThat(allOne.getMaxKey()).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void testNewMax(P432AllO1DataStructure allOne) {
    allOne.inc("hello");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    allOne.inc("leet");
    allOne.inc("leet");
    assertThat(allOne.getMaxKey()).isEqualTo("leet");
    assertThat(allOne.getMinKey()).isEqualTo("hello");
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void testNewMin(P432AllO1DataStructure allOne) {
    allOne.inc("hello");
    allOne.inc("hello");
    allOne.inc("hello");
    allOne.inc("leet");
    allOne.inc("leet");
    allOne.inc("leet");

    allOne.dec("hello");
    assertThat(allOne.getMinKey()).isEqualTo("hello");
    allOne.dec("leet");
    allOne.dec("leet");
    assertThat(allOne.getMinKey()).isEqualTo("leet");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
  }
}
