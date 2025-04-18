package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.Sets;
import com.willmolloy.leetcode.problemset.algorithms.medium.P138CopyListWithRandomPointer.Node;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * P138CopyListWithRandomPointerTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P138CopyListWithRandomPointerTest {

  private final P138CopyListWithRandomPointer p138CopyListWithRandomPointer =
      new P138CopyListWithRandomPointer();

  @Test
  void example1() {
    // Given
    Node head = new Node(7);
    head.next = new Node(13);
    head.next.next = new Node(11);
    head.next.next.next = new Node(10);
    head.next.next.next.next = new Node(1);

    head.next.random = head;
    head.next.next.random = head.next.next.next.next;
    head.next.next.next.random = head.next.next;
    head.next.next.next.next.random = head;

    // When
    Node copy = p138CopyListWithRandomPointer.copyRandomList(head);

    // Then
    assertEqualNotSame(head, copy);
  }

  @Test
  void example2() {
    // Given
    Node head = new Node(1);
    head.next = new Node(2);

    head.random = head.next;
    head.next.random = head.next;

    // When
    Node copy = p138CopyListWithRandomPointer.copyRandomList(head);

    // Then
    assertEqualNotSame(head, copy);
  }

  @Test
  void example3() {
    // Given
    Node head = new Node(3);
    head.next = new Node(3);
    head.next.next = new Node(3);

    head.next.random = head;

    // When
    Node copy = p138CopyListWithRandomPointer.copyRandomList(head);

    // Then
    assertEqualNotSame(head, copy);
  }

  @Test
  void example4() {
    assertThat(p138CopyListWithRandomPointer.copyRandomList(null)).isNull();
  }

  private static void assertEqualNotSame(Node a, Node b) {
    Set<Node> set = Sets.newIdentityHashSet();
    // test elements are equal
    assertEqualNotSame(a, b, set);
    // test saw right number of elements
    // i.e. didn't cheat and create new Nodes for the random pointer
    assertThat(set).hasSize(length(a));
  }

  private static void assertEqualNotSame(Node a, Node b, Set<Node> seen) {
    if (a == null) {
      assertThat(b).isNull();
      return;
    }
    if (!seen.add(a)) {
      return;
    }
    assertThat(a.val).isEqualTo(b.val);
    assertThat(a).isNotSameInstanceAs(b);
    assertEqualNotSame(a.random, b.random, seen);
    assertEqualNotSame(a.next, b.next, seen);
  }

  private static int length(Node a) {
    if (a == null) {
      return 0;
    }
    return 1 + length(a.next);
  }
}
