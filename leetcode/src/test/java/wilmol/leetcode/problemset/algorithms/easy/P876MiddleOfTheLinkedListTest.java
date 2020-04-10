package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by wilmol on 2020-04-10. */
class P876MiddleOfTheLinkedListTest {

  private final P876MiddleOfTheLinkedList fun = new P876MiddleOfTheLinkedList();

  @Test
  void oddSize() {
    assertThat(fun.middleNode(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(3, 4, 5));
  }

  @Test
  void evenSize() {
    assertThat(fun.middleNode(ListNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(ListNode.of(4, 5, 6));
  }

  @Test
  void empty() {
    assertThat(fun.middleNode(null)).isNull();
  }
}
