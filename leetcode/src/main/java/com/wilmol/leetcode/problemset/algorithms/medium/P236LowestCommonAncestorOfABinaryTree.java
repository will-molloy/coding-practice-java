package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

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
class P236LowestCommonAncestorOfABinaryTree {

  public BinaryTreeNode lowestCommonAncestor(
      BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
    // store parent of every node in map so can traverse up tree
    Map<BinaryTreeNode, BinaryTreeNode> parents = parents(root);

    // get path from p to root
    Set<BinaryTreeNode> pAncestors = ancestors(parents, p);

    // traverse path from q to root, stop at first node common on p to root path, that is the LCA
    BinaryTreeNode node = q;
    while (!pAncestors.contains(node)) {
      node = parents.get(node);
    }
    return node;
  }

  private Map<BinaryTreeNode, BinaryTreeNode> parents(BinaryTreeNode root) {
    Map<BinaryTreeNode, BinaryTreeNode> parents = new IdentityHashMap<>();
    parentDfs(parents, root, null);
    return Collections.unmodifiableMap(parents);
  }

  private void parentDfs(
      Map<BinaryTreeNode, BinaryTreeNode> parents, BinaryTreeNode node, BinaryTreeNode parent) {
    if (node == null) {
      return;
    }
    parents.put(node, parent);
    parentDfs(parents, node.left, node);
    parentDfs(parents, node.right, node);
  }

  private Set<BinaryTreeNode> ancestors(
      Map<BinaryTreeNode, BinaryTreeNode> parents, BinaryTreeNode node) {
    Set<BinaryTreeNode> ancestors = Collections.newSetFromMap(new IdentityHashMap<>());
    while (node != null) {
      ancestors.add(node);
      node = parents.get(node);
    }
    return Collections.unmodifiableSet(ancestors);
  }
}
