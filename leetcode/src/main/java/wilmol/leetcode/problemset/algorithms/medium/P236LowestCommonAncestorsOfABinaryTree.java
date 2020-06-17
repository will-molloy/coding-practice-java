package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-06-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree>https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Store parents in table so can traverse up tree.
 */
class P236LowestCommonAncestorsOfABinaryTree {

  public BinaryTreeNode lowestCommonAncestor(
      BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
    // store parent of every node in map so can traverse up tree
    // using integer as hash cause its unique (so correct) and cheaper to compute
    Map<Integer, BinaryTreeNode> parents = parents(root);

    // get path from p to root
    // using integer as hash again for same reasons as above
    Set<Integer> pAncestors = ancestors(parents, p);

    // traverse path from q to root, stop at first node common on p to root path, that is the LCA
    BinaryTreeNode node = q;
    while (!pAncestors.contains(node.val)) {
      node = parents.get(node.val);
    }
    return node;
  }

  private Map<Integer, BinaryTreeNode> parents(BinaryTreeNode root) {
    Map<Integer, BinaryTreeNode> parents = new HashMap<>();
    parentDfs(parents, root, null);
    return Collections.unmodifiableMap(parents);
  }

  private void parentDfs(
      Map<Integer, BinaryTreeNode> parents, BinaryTreeNode node, BinaryTreeNode parent) {
    if (node == null) {
      return;
    }
    parents.put(node.val, parent);
    parentDfs(parents, node.left, node);
    parentDfs(parents, node.right, node);
  }

  private Set<Integer> ancestors(Map<Integer, BinaryTreeNode> parents, BinaryTreeNode node) {
    Set<Integer> ancestors = new HashSet<>();
    while (node != null) {
      ancestors.add(node.val);
      node = parents.get(node.val);
    }
    return Collections.unmodifiableSet(ancestors);
  }
}
