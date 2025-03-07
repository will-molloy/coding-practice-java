package com.willmolloy.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
   * <p>{@code null} indicates a missing node.
   */
  public static TreeNode fromLevelOrder(Integer... values) {
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeNode that = (TreeNode) o;
    return serialise().equals(that.serialise());
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
    List<Integer> list = new ArrayList<>();
    // LinkedList permits null
    Deque<TreeNode> queue = new LinkedList<>();
    queue.addFirst(this);

    boolean emptyLevel = false;
    int levelSize = 0;
    // BFS until empty level
    while (!emptyLevel) {
      emptyLevel = true;
      levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.removeFirst();
        if (node != null) {
          emptyLevel = false;
          list.add(node.val);
          queue.addLast(node.left);
          queue.addLast(node.right);
        } else {
          list.add(null);
          // insert nulls so we get the nulls 'children' too
          queue.addLast(null);
          queue.addLast(null);
        }
      }
    }
    // leave out trailing nulls
    int last = list.size() - levelSize;
    while (list.get(last) == null) {
      last--;
    }
    return list.subList(0, last + 1);
  }
}
