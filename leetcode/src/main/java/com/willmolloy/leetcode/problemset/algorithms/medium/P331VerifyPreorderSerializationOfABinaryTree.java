package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree>https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Just need to track the number of children 'slots'; check each node has a slot and
 * all slots are consumed at the end.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P331VerifyPreorderSerializationOfABinaryTree {

  public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");

    int availableSlots = 1;

    for (String node : nodes) {
      if (availableSlots < 1) {
        return false;
      }

      if (node.equals("#")) {
        // null node consumes a slot
        availableSlots--;
      } else {
        // non-null node consumes a slot but produces space for 2 more (-1+2=1)
        availableSlots++;
      }
    }

    return availableSlots == 0;
  }
}
