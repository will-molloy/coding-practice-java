package wilmol.leetcode.common;

import java.util.Objects;
import java.util.StringJoiner;

/** Created by Will on 2019-03-30 at 21:49. */
public final class BinaryTreeNode {

  /**
   * Constructs a new binary tree containing the given values, in level order. {@code null}
   * indicates a missing node.
   */
  public static BinaryTreeNode fromLevelOrder(Integer... values) {
    if (values.length == 0 || values[0] == null) {
      return null;
    }
    BinaryTreeNode root = new BinaryTreeNode(values[0]);
    root.left = buildLevelOrder(1, values);
    root.right = buildLevelOrder(2, values);
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

  public final int val;

  @SuppressWarnings("PublicField")
  public BinaryTreeNode left;

  @SuppressWarnings("PublicField")
  public BinaryTreeNode right;

  private BinaryTreeNode(int value) {
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
    return val == that.val && Objects.equals(left, that.left) && Objects.equals(right, that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BinaryTreeNode.class.getSimpleName() + "[", "]")
        .add("value=" + val)
        .add("left=" + left)
        .add("right=" + right)
        .toString();
  }
}
