package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-12.
 *
 * <p><a
 * href=https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree>https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(log n) (recursion stack size)
 *
 * <p>Key: consistently maintaining left/right pointer as inclusive/exclusive to the array range
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P109ConvertSortedListToBinarySearchTree
 */
class P108ConvertSortedArrayToBinarySearchTree {

  // sorted = inorder traversal, so pick middle element as current nodes value at each step

  public BinaryTreeNode sortedArrayToBst(int[] nums) {
    return toBst(0, nums.length - 1, nums);
  }

  // left and right are both inclusive (i.e. represent the range nums[left, right])
  private BinaryTreeNode toBst(int left, int right, int[] nums) {
    if (right < left) {
      return null;
    }
    int mid = (left + right) >>> 1;
    BinaryTreeNode node = new BinaryTreeNode(nums[mid]);
    node.left = toBst(left, mid - 1, nums);
    node.right = toBst(mid + 1, right, nums);
    return node;
  }
}
