package com.willmolloy.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * BinaryTreeNode.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class BinaryTreeNode {

  /**
   * Constructs a new binary tree containing the given values, in level order. {@code null}
   * indicates a missing node.
   */
  public static BinaryTreeNode fromLevelOrder(Integer... values) {
    BinaryTreeNode root = new BinaryTreeNode(values[0]);
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

  private static BinaryTreeNode buildLevelOrder(int i, Integer... remainingValues) {
    BinaryTreeNode root = null;
    if (i < remainingValues.length && remainingValues[i] != null) {
      root = new BinaryTreeNode(remainingValues[i]);
      root.left = buildLevelOrder(2 * i + 1, remainingValues);
      root.right = buildLevelOrder(2 * i + 2, remainingValues);
    }
    return root;
  }

  public int val;

  @SuppressFBWarnings("PA_PUBLIC_PRIMITIVE_ATTRIBUTE")
  public BinaryTreeNode left;

  @SuppressFBWarnings("PA_PUBLIC_PRIMITIVE_ATTRIBUTE")
  public BinaryTreeNode right;

  /** public constructor required for leetcode submission. */
  public BinaryTreeNode(int value) {
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
    BinaryTreeNode that = (BinaryTreeNode) o;
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
  // won't halt if cycles exist (shouldn't given this class is used for binary trees!)
  private List<Integer> serialise() {
    List<Integer> list = new ArrayList<>();
    // LinkedList permits null
    Deque<BinaryTreeNode> queue = new LinkedList<>();
    queue.addFirst(this);

    boolean emptyLevel = false;
    int levelSize = 0;
    // BFS until empty level
    while (!emptyLevel) {
      emptyLevel = true;
      levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode node = queue.removeFirst();
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
