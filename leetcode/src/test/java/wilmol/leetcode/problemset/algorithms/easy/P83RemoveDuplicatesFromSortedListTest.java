package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by wilmol on 2019-12-14. */
class P83RemoveDuplicatesFromSortedListTest {

  private final P83RemoveDuplicatesFromSortedList fun = new P83RemoveDuplicatesFromSortedList();

  @Test
  void example1() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 2))).isEqualTo(ListNode.of(1, 2));
  }

  @Test
  void example2() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3))).isEqualTo(ListNode.of(1, 2, 3));
  }

  @Test
  void skipTwiceInARow() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 1))).isEqualTo(ListNode.of(1));
  }
}
