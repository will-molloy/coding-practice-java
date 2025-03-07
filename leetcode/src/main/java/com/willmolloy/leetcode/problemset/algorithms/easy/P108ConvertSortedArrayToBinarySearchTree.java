package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree>https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(log n) (recursion stack size)
 *
 * <p>Key: consistently maintaining left/right pointer as inclusive/exclusive to the array range
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P109ConvertSortedListToBinarySearchTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P108ConvertSortedArrayToBinarySearchTree {

  // sorted = inorder traversal, so pick middle element as current nodes value at each step

  public TreeNode sortedArrayToBst(int[] nums) {
    return toBst(0, nums.length - 1, nums);
  }

  // left and right are both inclusive (i.e. represent the range nums[left, right])
  private TreeNode toBst(int left, int right, int[] nums) {
    if (right < left) {
      return null;
    }
    int mid = (left + right) >>> 1;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = toBst(left, mid - 1, nums);
    node.right = toBst(mid + 1, right, nums);
    return node;
  }
}
