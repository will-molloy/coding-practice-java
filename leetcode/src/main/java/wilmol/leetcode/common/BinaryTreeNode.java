package wilmol.leetcode.common;

import java.util.Objects;
import java.util.StringJoiner;

/** Created by Will on 2019-03-30 at 21:49. */
public final class BinaryTreeNode {

  public final int val;

  public BinaryTreeNode left;

  public BinaryTreeNode right;

  public BinaryTreeNode(int value) {
    this.val = value;
  }

  /**
   * Builds the binary tree from level order.
   *
   * @param values node values, null indicates a missing node
   * @return new binary tree
   */
  public static BinaryTreeNode fromLevelOrder(Integer... values) {
    if (values.length == 0 || values[0] == null) {
      return null;
    }
    return new BinaryTreeNode(values);
  }

  private BinaryTreeNode(Integer... values) {
    this.val = values[0];
    this.left = buildLevelOrder(1, values);
    this.right = buildLevelOrder(2, values);
  }

  private static BinaryTreeNode buildLevelOrder(int i, Integer... remainingValues) {
    BinaryTreeNode root = null;
    if (i < remainingValues.length) {
      if (remainingValues[i] != null) {
        root = new BinaryTreeNode(remainingValues[i]);
        root.left = buildLevelOrder(2 * i + 1, remainingValues);
        root.right = buildLevelOrder(2 * i + 2, remainingValues);
      }
    }
    return root;
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
