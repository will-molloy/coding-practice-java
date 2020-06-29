package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/range-sum-query-immutable>https://leetcode.com/problems/range-sum-query-immutable</a>
 *
 * <p>Key: knowledge of ranges/intervals, prefix sum/segment tree.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P304RangeSumQuery2dImmutable
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P307RangeSumQueryMutable
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P303RangeSumQueryImmutable {

  /**
   * Solution which uses prefix sums.
   *
   * <p>Runtime: O(n) build time, O(1) query time.
   *
   * <p>Space: O(n)
   */
  static class PrefixSum {

    /** NumArray class. */
    static class NumArray {
      // O(n) space
      private final int[] prefixSum;

      // O(n) time
      NumArray(int[] nums) {
        // pre compute prefix sums
        // i.e. all sums [0..i] where i = [0..n]
        // then in sum method can compute in O(1):
        // i.e. sumRange[i..j] = sumRange[0..j] - sumRange[0..i)

        prefixSum = new int[nums.length];
        if (prefixSum.length == 0) {
          return;
        }
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
          prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
      }

      // O(1) time
      int sumRange(int i, int j) {
        // [0..j]
        int zeroToJ = prefixSum[j];
        // [0..i) (empty range if i = 0)
        int zeroUntilI = i > 0 ? prefixSum[i - 1] : 0;
        return zeroToJ - zeroUntilI;
      }
    }
  }

  /**
   * Solution which uses segment tree.
   *
   * <p>Runtime: O(n) build time, O(log n) query time. (More advantageous when there is an update
   * operation.)
   *
   * <p>Space: O(n)
   */
  static class SegmentTree {

    /** NumArray class. */
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

      // build node for nums[start, end]
      private Node build(int[] nums, int start, int end) {
        if (start == end) {
          // leaf node
          return new Node(start, end, nums[start], null, null);
        }
        int mid = mid(start, end);
        Node left = build(nums, start, mid);
        Node right = build(nums, mid + 1, end);
        return new Node(start, end, left.sum + right.sum, left, right);
      }

      private static int mid(int start, int end) {
        return start + (end - start) / 2;
      }

      // O(log n)
      int sumRange(int i, int j) {
        return query(root, i, j);
      }

      // sum nums[start, end]
      private int query(Node node, int start, int end) {
        if (start == node.start && end == node.end) {
          // query matches this nodes range
          // e.g. query=[2, 2] and node=[2, 2]
          return node.sum;
        } else {
          int mid = mid(node.start, node.end);
          if (end <= mid) {
            // query contained in left half of this nodes range
            // e.g. query=[0, 2] and node=[0, 5](left=[0, 2], right=[3, 5])
            return query(node.left, start, end);
          } else if (start > mid) {
            // query contained in right half of this nodes range
            // e.g. query=[3, 5] and node=[0, 5](left=[0, 2], right=[3, 5])
            return query(node.right, start, end);
          } else {
            // query overlaps left and right halves of this nodes range
            // e.g. query=[2, 5] and node=[0, 5](left=[0, 2], right=[3, 5])
            return query(node.left, start, mid) + query(node.right, mid + 1, end);
          }
        }
      }

      /** Represents a Node of the segment tree. */
      private static final class Node {

        /** Start of the range (inclusive) represented by this node. */
        private final int start;
        /** End of the range (inclusive) represented by this node. */
        private final int end;

        /** Value held by this node. (Here, the sum over the range represented by this node). */
        private final int sum;

        /** Left child. */
        private final Node left;
        /** Right child. */
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
}
