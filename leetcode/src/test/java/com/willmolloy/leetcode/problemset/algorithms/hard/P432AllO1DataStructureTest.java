package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link P432AllO1DataStructure}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P432AllO1DataStructureTest {

  @Test
  void example1() {
    P432AllO1DataStructure allOne = new P432AllO1DataStructure();
    allOne.inc("hello");
    allOne.inc("hello");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    assertThat(allOne.getMinKey()).isEqualTo("hello");
    allOne.inc("leet");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    assertThat(allOne.getMinKey()).isEqualTo("leet");
  }

  @Test
  void testEmpty() {
    P432AllO1DataStructure allOne = new P432AllO1DataStructure();
    assertThat(allOne.getMaxKey()).isEmpty();
    assertThat(allOne.getMinKey()).isEmpty();
  }

  @Test
  void testDecreaseNoEntryStaysEmpty() {
    P432AllO1DataStructure allOne = new P432AllO1DataStructure();
    allOne.dec("hello");
    assertThat(allOne.getMaxKey()).isEmpty();
    assertThat(allOne.getMinKey()).isEmpty();
  }

  @Test
  void testDecreaseRemovesEntry() {
    P432AllO1DataStructure allOne = new P432AllO1DataStructure();
    allOne.inc("hello");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    allOne.dec("hello");
    assertThat(allOne.getMaxKey()).isEmpty();
  }

  @Test
  void testNewMax() {
    P432AllO1DataStructure allOne = new P432AllO1DataStructure();
    allOne.inc("hello");
    assertThat(allOne.getMaxKey()).isEqualTo("hello");
    allOne.inc("leet");
    allOne.inc("leet");
    assertThat(allOne.getMaxKey()).isEqualTo("leet");
    assertThat(allOne.getMinKey()).isEqualTo("hello");
  }

  @Test
  void testNewMin() {
    P432AllO1DataStructure allOne = new P432AllO1DataStructure();
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
