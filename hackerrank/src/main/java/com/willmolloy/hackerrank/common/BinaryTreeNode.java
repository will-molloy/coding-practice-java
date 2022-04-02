package com.willmolloy.hackerrank.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Objects;

/**
 * BinaryTreeNode.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD")
public final class BinaryTreeNode {

  public final int data;

  public BinaryTreeNode left;

  public BinaryTreeNode right;

  private BinaryTreeNode(int data) {
    this.data = data;
  }

  public static BinaryTreeNode of(int data) {
    return new BinaryTreeNode(data);
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
    return data == that.data
        && Objects.equals(left, that.left)
        && Objects.equals(right, that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, left, right);
  }
}
