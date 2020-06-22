package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2020-05-01.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-paths>https://leetcode.com/problems/binary-tree-paths/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: Just do string concatenation; passing around mutable objects like list of ints or string
 * builder is problematic and requires copying the data structure anyway.
 */
class P257BinaryTreePaths {

  public List<String> binaryTreePaths(BinaryTreeNode root) {
    List<String> paths = new ArrayList<>();
    dfs(root, "", paths);
    return paths;
  }

  private void dfs(BinaryTreeNode node, String path, List<String> paths) {
    if (node == null) {
      return;
    }
    path += (path.isEmpty() ? "" : "->") + node.val;
    if (node.left == null && node.right == null) {
      paths.add(path);
    }
    dfs(node.left, path, paths);
    dfs(node.right, path, paths);
  }
}
