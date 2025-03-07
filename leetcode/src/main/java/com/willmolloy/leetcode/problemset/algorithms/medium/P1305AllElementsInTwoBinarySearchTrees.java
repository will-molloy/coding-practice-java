package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/all-elements-in-two-binary-search-trees>https://leetcode.com/problems/all-elements-in-two-binary-search-trees/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Inorder traversal each BST and then merge the two sorted lists.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P21MergeTwoSortedLists
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P23MergeKSortedLists
 * @see P94BinaryTreeInorderTraversal
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1305AllElementsInTwoBinarySearchTrees {

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = inorder(root1, new ArrayList<>());
    List<Integer> list2 = inorder(root2, new ArrayList<>());
    return mergeSortedLists(list1, list2);
  }

  private List<Integer> inorder(TreeNode root, List<Integer> result) {
    if (root == null) {
      return result;
    }
    inorder(root.left, result);
    result.add(root.val);
    inorder(root.right, result);
    return result;
  }

  private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
    List<Integer> result = new ArrayList<>();

    int i = 0;
    int j = 0;
    while (i < list1.size() && j < list2.size()) {
      if (list1.get(i) < list2.get(j)) {
        result.add(list1.get(i));
        i++;
      } else {
        result.add(list2.get(j));
        j++;
      }
    }
    while (i < list1.size()) {
      result.add(list1.get(i));
      i++;
    }
    while (j < list2.size()) {
      result.add(list2.get(j));
      j++;
    }

    return result;
  }
}
