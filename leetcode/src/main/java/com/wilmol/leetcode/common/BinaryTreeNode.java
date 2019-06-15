package com.wilmol.leetcode.common;

import java.util.Objects;

import com.google.common.base.Preconditions;

/**
 * Created by Will on 2019-03-30 at 21:49
 */
public class BinaryTreeNode
{
  private final int value;

  public BinaryTreeNode left;

  public BinaryTreeNode right;

  /**
   * Constructs from level order
   */
  public BinaryTreeNode(int... values)
  {
    Preconditions.checkArgument(values.length > 0, "Tree must have at least one node.");
    this.value = values[0];
    this.left = buildLevelOrder(1, values);
    this.right = buildLevelOrder(2, values);
  }

  private static BinaryTreeNode buildLevelOrder(int i, int... arr)
  {
    BinaryTreeNode root = null;
    if (i < arr.length)
    {
      root = new BinaryTreeNode(arr[i]);
      root.left = buildLevelOrder(2 * i + 1, arr);
      root.right = buildLevelOrder(2 * i + 2, arr);
    }
    return root;
  }

  @Override
  public String toString()
  {
    return "BinaryTreeNode{" +
        "val=" + value +
        ", left=" + left +
        ", right=" + right +
        '}';
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }
    BinaryTreeNode that = (BinaryTreeNode) o;
    return value == that.value &&
        Objects.equals(left, that.left) &&
        Objects.equals(right, that.right);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(value, left, right);
  }
}
