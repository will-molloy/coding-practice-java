package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P284PeekingIteratorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P284PeekingIteratorTest {

  @Test
  void example() {
    P284PeekingIterator.PeekingIterator peekingIterator =
        new P284PeekingIterator.PeekingIterator(List.of(1, 2, 3).iterator());

    assertThat(peekingIterator.next()).isEqualTo(1);
    assertThat(peekingIterator.peek()).isEqualTo(2);
    assertThat(peekingIterator.next()).isEqualTo(2);
    assertThat(peekingIterator.next()).isEqualTo(3);
    assertThat(peekingIterator.hasNext()).isFalse();
  }
}
