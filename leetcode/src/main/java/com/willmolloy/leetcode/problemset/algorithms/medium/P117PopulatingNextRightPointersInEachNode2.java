package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.problemset.algorithms.medium.P116PopulatingNextRightPointersInEachNode.Node;

/**
 * <a
 * href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii>https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii</a>
 *
 * <p>Key: copy Populating-Next-Right-Pointers-in-Each-Node-I
 *
 * @see P116PopulatingNextRightPointersInEachNode
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P117PopulatingNextRightPointersInEachNode2 {

  // TODO O(1) space solution

  private final P116PopulatingNextRightPointersInEachNode delegate =
      new P116PopulatingNextRightPointersInEachNode.ExtraSpace();

  public Node connect(Node root) {
    return delegate.connect(root);
  }
}
