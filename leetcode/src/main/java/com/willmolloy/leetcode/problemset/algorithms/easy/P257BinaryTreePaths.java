package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/binary-tree-paths>https://leetcode.com/problems/binary-tree-paths/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key idea: Just do string concatenation; passing around mutable objects like list of ints or
 * string builder is problematic and requires copying the data structure anyway.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P257BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    dfs(root, "", paths);
    return paths;
  }

  private void dfs(TreeNode node, String path, List<String> paths) {
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
