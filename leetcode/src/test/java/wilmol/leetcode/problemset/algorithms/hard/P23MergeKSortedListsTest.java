package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by Will on 2019-07-23 at 21:37. */
class P23MergeKSortedListsTest {

  private final P23MergeKSortedLists fun = new P23MergeKSortedLists();

  @Test
  void example() {
    assertThat(
            fun.mergeKLists(
                new ListNode[] {ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)}))
        .isEqualTo(ListNode.of(1, 1, 2, 3, 4, 4, 5, 6));
  }
}