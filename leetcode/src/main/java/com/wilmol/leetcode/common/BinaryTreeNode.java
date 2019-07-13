package com.wilmol.leetcode.common;

import java.util.Objects;

/** Created by Will on 2019-03-30 at 21:49. */
public final class BinaryTreeNode {

  public final int value;

  public BinaryTreeNode left;

  public BinaryTreeNode right;

  public static BinaryTreeNode fromLevelOrder(int... values) {
    return new BinaryTreeNode(values);
  }

  private BinaryTreeNode(int... values) {
    this.value = values[0];
    this.left = buildLevelOrder(1, values);
    this.right = buildLevelOrder(2, values);
  }

  private static BinaryTreeNode buildLevelOrder(int i, int... remainingValues) {
    BinaryTreeNode root = null;
    if (i < remainingValues.length) {
      root = new BinaryTreeNode(remainingValues[i]);
      root.left = buildLevelOrder(2 * i + 1, remainingValues);
      root.right = buildLevelOrder(2 * i + 2, remainingValues);
    }
    return root;
  }

  @Override
  public String toString() {
    return String.format("%d, %s, %s", value, left, right);
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
    return value == that.value
        && Objects.equals(left, that.left)
        && Objects.equals(right, that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, left, right);
  }
}
