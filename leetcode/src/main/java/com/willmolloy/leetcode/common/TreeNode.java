package com.willmolloy.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import javax.annotation.Nullable;

/**
 * Definition for a binary tree node.
 *
 * @author leetcode
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class TreeNode {

  /**
   * Constructs a new binary tree containing the given values, in level order.
   *
   * <p>{@code null} indicates a missing <i>subtree</i>.
   */
  public static TreeNode fromLevelOrder2(Integer... values) {
    if (values == null || values.length == 0 || values[0] == null) {
      return null;
    }

    TreeNode root = new TreeNode(values[0]);

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    int i = 1;
    while (!queue.isEmpty() && i < values.length) {
      TreeNode node = queue.remove();

      if (values[i] != null) {
        node.left = new TreeNode(values[i]);
        queue.add(node.left);
      }
      i++;

      if (i < values.length && values[i] != null) {
        node.right = new TreeNode(values[i]);
        queue.add(node.right);
      }
      i++;
    }

    if (i < values.length) {
      throw new IllegalArgumentException("Expected all nodes to be reachable.");
    }
    return root;
  }

  /**
   * Constructs a new binary tree containing the given values, in level order.
   *
   * <p>{@code null} indicates a missing node.
   */
  public static TreeNode fromLevelOrder(Integer... values) {
    if (values == null || values.length == 0 || values[0] == null) {
      return null;
    }

    TreeNode root = new TreeNode(values[0]);
    root.left = buildLevelOrder(1, values);
    root.right = buildLevelOrder(2, values);

    List<Integer> serialisedValues = root.serialise().stream().filter(Objects::nonNull).toList();
    List<Integer> inputValues = Arrays.stream(values).filter(Objects::nonNull).toList();
    if (!serialisedValues.equals(inputValues)) {
      // serialise method will skip unreachable node values (... since they're unreachable)
      // so if doesn't equal input value list, throw iae
      throw new IllegalArgumentException("Expected all nodes to be reachable");
    }
    return root;
  }

  private static TreeNode buildLevelOrder(int i, Integer... remainingValues) {
    TreeNode root = null;
    if (i < remainingValues.length && remainingValues[i] != null) {
      root = new TreeNode(remainingValues[i]);
      root.left = buildLevelOrder(2 * i + 1, remainingValues);
      root.right = buildLevelOrder(2 * i + 2, remainingValues);
    }
    return root;
  }

  public int val;

  @SuppressFBWarnings("PA_PUBLIC_PRIMITIVE_ATTRIBUTE")
  @Nullable
  public TreeNode left;

  @SuppressFBWarnings("PA_PUBLIC_PRIMITIVE_ATTRIBUTE")
  @Nullable
  public TreeNode right;

  public TreeNode(int value) {
    this.val = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeNode treeNode)) {
      return false;
    }
    return serialise().equals(treeNode.serialise());
  }

  @Override
  public int hashCode() {
    return serialise().hashCode();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + serialise();
  }

  // serialises by level order
  // won't halt if cycles exist (unlikely given this class represents a tree!)
  private List<Integer> serialise() {
    List<Integer> result = new ArrayList<>();

    // LinkedList permits null
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(this);

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      if (node != null) {
        result.add(node.val);
        queue.add(node.left);
        queue.add(node.right);
      } else {
        result.add(null);
      }
    }

    // remove trailing nulls
    int last = result.size() - 1;
    while (last >= 0 && result.get(last) == null) {
      last--;
    }
    return result.subList(0, last + 1);
  }
}
