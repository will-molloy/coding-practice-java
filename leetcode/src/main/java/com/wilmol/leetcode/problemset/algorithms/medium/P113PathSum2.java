package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2020-02-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/path-sum-ii>https://leetcode.com/problems/path-sum-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h) TODO is that correct? Each stack frame will hold a different path list. Worst case
 * (full tree) O(height*width) ???
 *
 * <p>Key: A leaf is a node with no children. Knowing when to copy temporary data.
 */
class P113PathSum2 {

  public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
    return pathSum(root, sum, 0, new ArrayList<>(), new ArrayList<>());
  }

  private List<List<Integer>> pathSum(
      BinaryTreeNode node,
      int sum,
      int currentSum,
      List<List<Integer>> validPaths,
      List<Integer> currentPath) {
    if (node == null) {
      // bottomed out
      return validPaths;
    }

    currentSum += node.val;
    // copy path list because it will diverge on recursive call
    currentPath = new ArrayList<>(currentPath);
    currentPath.add(node.val);

    if (node.left == null && node.right == null) {
      // leaf node
      if (sum == currentSum) {
        // add to results
        validPaths.add(currentPath);
      }
      return validPaths;
    }

    // non-leaf
    pathSum(node.left, sum, currentSum, validPaths, currentPath);
    pathSum(node.right, sum, currentSum, validPaths, currentPath);
    return validPaths;
  }
}
