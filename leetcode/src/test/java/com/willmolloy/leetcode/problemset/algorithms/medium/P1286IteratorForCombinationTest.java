package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.medium.P1286IteratorForCombination.CombinationIterator;
import org.junit.jupiter.api.Test;

/**
 * P1286IteratorForCombinationTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1286IteratorForCombinationTest {

  @Test
  void example() {
    CombinationIterator iterator = new CombinationIterator("abc", 2);

    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo("ab");
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo("ac");
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo("bc");
    assertThat(iterator.hasNext()).isFalse();
  }

  @Test
  void charactersLengthEqualsCombinationLength() {
    CombinationIterator iterator = new CombinationIterator("abc", 3);

    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo("abc");
    assertThat(iterator.hasNext()).isFalse();
  }
}
