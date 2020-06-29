package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.problemset.algorithms.medium.P116PopulatingNextRightPointersInEachNode.Node;

/**
 * <a
 * href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii>https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii</a>
 *
 * <p>Key: copy Populating-Next-Right-Pointers-in-Each-Node-I
 *
 * @see P116PopulatingNextRightPointersInEachNode
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P117PopulatingNextRightPointersInEachNode2 {

  private final P116PopulatingNextRightPointersInEachNode delegate =
      new P116PopulatingNextRightPointersInEachNode();

  public Node connect(Node root) {
    return delegate.connect(root);
  }
}
