package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.easy.P1656DesignAnOrderedStream.OrderedStream;
import org.junit.jupiter.api.Test;

/**
 * P1656DesignAnOrderedStreamTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1656DesignAnOrderedStreamTest {

  @Test
  void example() {
    OrderedStream os = new OrderedStream(5);
    assertThat(os.insert(3, "c")).containsExactly().inOrder();
    assertThat(os.insert(1, "a")).containsExactly("a").inOrder();
    assertThat(os.insert(2, "b")).containsExactly("b", "c").inOrder();
    assertThat(os.insert(5, "e")).containsExactly().inOrder();
    assertThat(os.insert(4, "d")).containsExactly("d", "e").inOrder();
  }
}
