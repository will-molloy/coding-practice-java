package wilmol.leetcode.common;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-08. */
class ListNodeTest {

  @Test
  void testToStringNoCycle() {
    ListNode head = ListNode.of(1, 2, 3);
    assertThat(head.toString()).isEqualTo("[1, 2, 3]");
  }

  @Test
  void testToStringWithCycle() {
    ListNode node = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node.next = node2;
    node2.next = node;
    assertThat(node.toString()).isEqualTo("[1, 2] (cycling)");
  }
}
