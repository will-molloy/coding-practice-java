package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree>https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Store parents in table so can traverse up tree.
 *
 * @see P1530NumberOfGoodLeafNodesPairs
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P236LowestCommonAncestorOfABinaryTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // store parent of every node in map so can traverse up tree
    Map<TreeNode, TreeNode> parents = parents(root);

    // get path from p to root
    Set<TreeNode> pAncestors = ancestors(parents, p);

    // traverse path from q to root, stop at first node common on p to root path, that is the LCA
    TreeNode node = q;
    while (!pAncestors.contains(node)) {
      node = parents.get(node);
    }
    return node;
  }

  private Map<TreeNode, TreeNode> parents(TreeNode root) {
    Map<TreeNode, TreeNode> parents = new IdentityHashMap<>();
    parentDfs(parents, root, null);
    return Collections.unmodifiableMap(parents);
  }

  private void parentDfs(Map<TreeNode, TreeNode> parents, TreeNode node, TreeNode parent) {
    if (node == null) {
      return;
    }
    parents.put(node, parent);
    parentDfs(parents, node.left, node);
    parentDfs(parents, node.right, node);
  }

  private Set<TreeNode> ancestors(Map<TreeNode, TreeNode> parents, TreeNode node) {
    Set<TreeNode> ancestors = Collections.newSetFromMap(new IdentityHashMap<>());
    while (node != null) {
      ancestors.add(node);
      node = parents.get(node);
    }
    return Collections.unmodifiableSet(ancestors);
  }
}
