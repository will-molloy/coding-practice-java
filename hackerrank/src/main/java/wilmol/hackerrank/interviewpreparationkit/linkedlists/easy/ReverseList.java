package wilmol.hackerrank.interviewpreparationkit.linkedlists.easy;

import wilmol.hackerrank.common.DoublyLinkedListNode;

/**
 * Created by Will on 28/03/2019.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists>https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists</a>
 *
 * <p>Runtime: O(n)
 */
final class ReverseList {

  private ReverseList() {}

  static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    if (head.next == null) {
      return head;
    }

    DoublyLinkedListNode node = head;
    DoublyLinkedListNode prev = null;
    while (node != null) {
      // change pointers for just one node each iteration
      prev = node.prev;
      DoublyLinkedListNode next = node.next;
      node.next = prev;
      node.prev = next;
      node = next;
    }
    return prev.prev;
  }
}
