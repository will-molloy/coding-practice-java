package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/path-sum-iii>https://leetcode.com/problems/path-sum-iii/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO O(n) is possible
 *
 * <p>Extra memory: O(n<sup>2</sup>)
 *
 * <p>Key: Need to consider all possible paths (i.e. starting and ending at any node on path from
 * root to leaf). Make DFS state all paths ending at current node. Easy to see with {@code
 * List<List<Integer>> paths} and then use {@code Map<Integer, Integer> pathSumCounts} for
 * efficiency.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P112PathSum
 * @see P113PathSum2
 */
class P437PathSum3 {

  private int result;

  public int pathSum(BinaryTreeNode root, int sum) {
    result = 0;
    dfs(root, Collections.emptyMap(), sum);
    return result;
  }

  private void dfs(BinaryTreeNode node, Map<Integer, Integer> pathSumCounts, int target) {
    if (node == null) {
      return;
    }

    // want all paths ending at current node so add current node to paths given by parent
    Map<Integer, Integer> pathSumCountsCopy = new HashMap<>();
    for (Map.Entry<Integer, Integer> e : pathSumCounts.entrySet()) {
      pathSumCountsCopy.put(e.getKey() + node.val, e.getValue());
    }
    // new singleton path for this node
    pathSumCountsCopy.put(node.val, pathSumCountsCopy.getOrDefault(node.val, 0) + 1);

    result += pathSumCountsCopy.getOrDefault(target, 0);

    dfs(node.left, Collections.unmodifiableMap(pathSumCountsCopy), target);
    dfs(node.right, Collections.unmodifiableMap(pathSumCountsCopy), target);
  }
}
