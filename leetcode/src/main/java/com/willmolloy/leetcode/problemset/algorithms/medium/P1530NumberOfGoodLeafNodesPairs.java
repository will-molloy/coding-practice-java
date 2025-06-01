package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-good-leaf-nodes-pairs>https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/</a>
 *
 * <p>Runtime: O(n<sup>2</sup> * h) - O(n) leaves, compare each leaf with each leaf, LCA is O(h).
 * But worse cases for LCA means fewer leaves.
 *
 * <p>Extra memory: O(n) - copy tree + store each path root to leaf (essentially copy again)
 *
 * <p>Key idea: Distance between nodes in tree is: d(root, n1) + d(root, n2) - 2 * d(root, lca(n1,
 * n2)).
 *
 * @see P236LowestCommonAncestorOfABinaryTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("URF_UNREAD_FIELD")
final class P1530NumberOfGoodLeafNodesPairs {

  // TODO better solution, don't need nested loop on leafs?

  public int countPairs(TreeNode root, int distance) {
    // copy graph adding some useful information such as height, parent, isLeaf
    // also assign unique label
    Map<Integer, MyBinaryTreeNode> nodes = new HashMap<>();
    dfsCopy(root, nodes, null, new int[] {0}, 0);

    List<MyBinaryTreeNode> leafs = nodes.values().stream().filter(node -> node.isLeaf).toList();
    int count = 0;
    for (int i = 0; i < leafs.size(); i++) {
      for (int j = i + 1; j < leafs.size(); j++) {
        MyBinaryTreeNode leaf1 = leafs.get(i);
        MyBinaryTreeNode leaf2 = leafs.get(j);
        int dist = leaf1.height + leaf2.height - 2 * lca(leaf1, leaf2).height;
        if (dist <= distance) {
          count++;
        }
      }
    }
    return count;
  }

  private MyBinaryTreeNode dfsCopy(
      TreeNode node,
      Map<Integer, MyBinaryTreeNode> nodes,
      MyBinaryTreeNode parent,
      int[] count,
      int height) {
    if (node == null) {
      return null;
    }
    MyBinaryTreeNode nodeCopy = new MyBinaryTreeNode();
    nodes.put(count[0], nodeCopy);
    nodeCopy.isLeaf = node.left == null && node.right == null;
    nodeCopy.uniqueVal = count[0]++;
    nodeCopy.height = height++;
    nodeCopy.left = dfsCopy(node.left, nodes, nodeCopy, count, height);
    nodeCopy.right = dfsCopy(node.right, nodes, nodeCopy, count, height);
    nodeCopy.parent = parent;
    return nodeCopy;
  }

  private MyBinaryTreeNode lca(MyBinaryTreeNode node1, MyBinaryTreeNode node2) {
    // lazily compute path, get TLE if not cached
    LinkedHashSet<Integer> path;
    if (node1.path != null) {
      path = node1.path;
    } else {
      path = new LinkedHashSet<>();
      node1.path = path;
      while (node1 != null) {
        path.add(node1.uniqueVal);
        node1 = node1.parent;
      }
    }

    while (!path.contains(node2.uniqueVal)) {
      node2 = node2.parent;
    }
    return node2;
  }

  private static final class MyBinaryTreeNode {
    int uniqueVal;
    int height;
    MyBinaryTreeNode left;
    MyBinaryTreeNode right;
    MyBinaryTreeNode parent;
    boolean isLeaf;
    LinkedHashSet<Integer> path;
  }
}
