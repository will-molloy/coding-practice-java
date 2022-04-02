package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree>https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/</a>
 *
 * <p>Runtime: O(n log(n))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Gather x and y co-ords for each node then do grouping/sorting into required output
 * format.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P987VerticalOrderTraversalOfABinaryTree {

  public List<List<Integer>> verticalTraversal(BinaryTreeNode root) {
    Map<Integer, Integer> x = new HashMap<>();
    Map<Integer, Integer> y = new HashMap<>();
    dfs(root, 0, 0, x, y);

    // group by x val
    Map<Integer, List<Integer>> grouped =
        x.keySet().stream().collect(Collectors.groupingBy(x::get));
    return grouped.entrySet().stream()
        // sort outer lists by x val ascending
        .sorted(Map.Entry.comparingByKey())
        .map(Map.Entry::getValue)
        // sort inner lists by y val descending -> node val ascending
        .map(
            list ->
                list.stream()
                    .sorted(
                        Comparator.comparing((Function<Integer, Integer>) y::get)
                            .reversed()
                            .thenComparing(Function.identity()))
                    .collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  private void dfs(
      BinaryTreeNode node, int x, int y, Map<Integer, Integer> xMap, Map<Integer, Integer> yMap) {
    if (node == null) {
      return;
    }
    xMap.put(node.val, x);
    yMap.put(node.val, y);
    dfs(node.left, x - 1, y - 1, xMap, yMap);
    dfs(node.right, x + 1, y - 1, xMap, yMap);
  }
}
