package com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;

/**
 * Created by Will on 27/03/2019
 * <p>
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
 * Insert node into linked list.
 * <p>
 * Runtime: O(n)
 */
class InsertNodeAtPosition
{

  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position)
  {
    SinglyLinkedListNode nodeToInsert = SinglyLinkedListNode.of(data);

    SinglyLinkedListNode prevNode = null;
    SinglyLinkedListNode currentNode = head;
    while (position > 0 && currentNode != null)
    {
      position -= 1;
      prevNode = currentNode;
      currentNode = currentNode.next;
    }
    if (prevNode == null)
    {
      // inserting at start of list
      head = nodeToInsert;
    }
    else
    {
      // inserting at middle or end of list
      prevNode.next = nodeToInsert;
    }
    nodeToInsert.next = currentNode;
    return head;
  }

}
