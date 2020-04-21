package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-03-06.
 *
 * <p><a
 * href=https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal>https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal</a>
 *
 * <p>Runtime: O(n lgn) (recurrence T(n) = 2T(n/2 - 1) + O(n))
 *
 * <p>Space: O(h)
 *
 * <p>Key: how binary tree traversals are laid out in an array
 *
 * @see P105ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @see P1008ConstructBinarySearchTreeFromPreorderTraversal
 */
class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(asList(inorder), asList(postorder));
  }

  private BinaryTreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
    if (postorder.isEmpty()) {
      return null;
    }
    BinaryTreeNode root = new BinaryTreeNode(postorder.get(postorder.size() - 1));
    if (postorder.size() == 1) {
      return root;
    }
    // find index of root in inorder seq
    int i;
    for (i = 0; i < inorder.size(); i++) {
      if (inorder.get(i) == root.val) {
        break;
      }
    }
    // inorder: left-node-right
    // postorder: left-right-node
    root.left = buildTree(inorder.subList(0, i), postorder.subList(0, i));
    root.right =
        buildTree(
            inorder.subList(i + 1, inorder.size()), postorder.subList(i, postorder.size() - 1));
    return root;
  }

  private static List<Integer> asList(int[] a) {
    return Arrays.stream(a).boxed().collect(Collectors.toList());
  }
}
