package wilmol.hackerrank.interviewpreparationkit.linkedlists.easy;

import wilmol.hackerrank.common.SinglyLinkedListNode;

/**
 * Created by Will on 28/03/2019.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists>https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists</a>
 *
 * <p>Given two lists which have a common suffix, contains the merge point.
 *
 * <p>Runtime: O(n)
 */
final class FindMergePointOfTwoLists {

  private FindMergePointOfTwoLists() {}

  // e.g.
  // A: 9 -> 4 -> 5
  // B: 1 -> 2 -> 3 -> 4 -> 5
  // (common suffix is 4 -> 5, merge on 4)
  // Given they have a common suffix, if we concat the two lists (both ways), they must meet the
  // convergence after the
  // same number of iterations.
  // e.g.
  // AB: 9 -> 4 -> 5 -> | -> 1 -> 2 -> 3 -> (4) -> 5
  // BA: 1 -> 2 -> 3 -> 4 -> 5 -> | -> 9 -> (4) -> 5
  // Because, if we suffix a list - both of them get suffixed the same amount (common suffix)
  // and if we prefix a list - both of them get prefixed the same amount (since we concat)
  // Because addition (in this case of lengths) is commutative.
  // I.e. the trivial case (where both lists are the same size, and therefore equal (due to common
  // suffix)) is being
  // applied in all scenarios.
  static int findMergeNode(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
    SinglyLinkedListNode nodeA = headA;
    SinglyLinkedListNode nodeB = headB;

    // iterate both until the nodes match
    while (nodeA != nodeB) {
      if (nodeA != null) {
        nodeA = nodeA.next;
      } else {
        // reached the end of A, start from B
        nodeA = headB;
      }
      if (nodeB != null) {
        nodeB = nodeB.next;
      } else {
        // reached the end of B, start from A
        nodeB = headA;
      }
    }
    return nodeA.data;
  }
}
