package wilmol.leetcode.common;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** Created by Will on 2019-03-30 at 21:49. */
public final class BinaryTreeNode {

  /**
   * Constructs a new binary tree containing the given values, in level order. {@code null}
   * indicates a missing node.
   */
  // TODO, could enter nodes that don't have parents, fail in that case? (currently ignores them)
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
    return serialise().equals(that.serialise());
  }

  @Override
  public int hashCode() {
    return serialise().hashCode();
  }

  @Override
  public String toString() {
    return serialise().toString();
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
    // leave out final level of nulls
    return list.subList(0, list.size() - levelSize);
  }
}
