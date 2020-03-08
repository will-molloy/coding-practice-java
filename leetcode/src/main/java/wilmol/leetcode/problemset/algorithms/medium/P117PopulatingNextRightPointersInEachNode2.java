package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.problemset.algorithms.medium.P116PopulatingNextRightPointersInEachNode.Node;

/**
 * Created by wilmol on 2020-03-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii>https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii</a>
 *
 * <p>Key: copy Populating-Next-Right-Pointers-in-Each-Node-I
 *
 * @see P116PopulatingNextRightPointersInEachNode
 */
class P117PopulatingNextRightPointersInEachNode2 {

  private final P116PopulatingNextRightPointersInEachNode delegate =
      new P116PopulatingNextRightPointersInEachNode();

  public Node connect(Node root) {
    return delegate.connect(root);
  }
}
