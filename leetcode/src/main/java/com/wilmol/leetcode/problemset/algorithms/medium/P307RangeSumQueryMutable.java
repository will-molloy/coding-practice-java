package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-15.
 *
 * <p><a
 * href=https://leetcode.com/problems/range-sum-query-mutable>https://leetcode.com/problems/range-sum-query-mutable</a>
 *
 * <p>Runtime: O(n) build, O(log n) query, O(log n) update.
 *
 * <p>Space: O(n)
 *
 * <p>Key: Segment tree. Key to implementing segment tree? Splitting range in half.
 */
class P307RangeSumQueryMutable {

  static class NumArray {

    private final Node root;

    // O(n)
    NumArray(int[] nums) {
      if (nums.length == 0) {
        root = new Node(0, 0, 0, null, null);
      } else {
        root = build(nums, 0, nums.length - 1);
      }
    }

    // build Node for nums[start, end]
    private Node build(int[] nums, int start, int end) {
      if (start == end) {
        return new Node(start, end, nums[start], null, null);
      }
      int mid = mid(start, end);
      Node left = build(nums, start, mid);
      Node right = build(nums, mid + 1, end);
      int sum = left.sum + right.sum;
      return new Node(start, end, sum, left, right);
    }

    private static int mid(int start, int end) {
      return start + (end - start) / 2;
    }

    // O(log n)
    void update(int i, int val) {
      update(root, i, val);
    }

    private void update(Node node, int i, int val) {
      if (node.start == i && node.end == i) {
        // base case: found node to update
        node.sum = val;
        return;
      }
      int mid = mid(node.start, node.end);
      if (i <= mid) {
        // update left
        update(node.left, i, val);
      } else {
        // update right
        update(node.right, i, val);
      }
      // bubble up new sum
      node.sum = node.left.sum + node.right.sum;
    }

    // O(log n)
    int sumRange(int start, int end) {
      return query(root, start, end);
    }

    private int query(Node node, int start, int end) {
      if (start == node.start && end == node.end) {
        // base case: found node with range matching the query
        return node.sum;
      }
      int mid = mid(node.start, node.end);
      if (end <= mid) {
        // query in left half
        return query(node.left, start, end);
      } else if (start > mid) {
        // query in right half
        return query(node.right, start, end);
      } else {
        // query in both halves
        return query(node.left, start, mid) + query(node.right, mid + 1, end);
      }
    }

    /** Segment tree node. */
    private static final class Node {
      // represents range [start, end]
      private final int start;
      private final int end;

      // mutable value (sum)
      private int sum;

      private final Node left;
      private final Node right;

      private Node(int start, int end, int sum, Node left, Node right) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = left;
        this.right = right;
      }
    }
  }
}
