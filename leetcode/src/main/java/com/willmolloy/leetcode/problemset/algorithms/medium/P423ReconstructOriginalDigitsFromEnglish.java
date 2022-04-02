package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/reconstruct-original-digits-from-english>https://leetcode.com/problems/reconstruct-original-digits-from-english/</a>
 *
 * <p>Runtime: O(s)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Find unique letters for each digit. E.g. only zero has 'z'. Then count the occurrence of
 * those letters. Digits which have such unique letters will now have the correct/final count.
 *
 * <p>For digits which don't have any unique letters, find a shared letter such that the digits it
 * shares the letter with would have their count finalised first. I.e. the graph of shared letters
 * forms a DAG. E.g. 6 and 7 have 's', but only 6 has 'x' so 6 -> 7 is a DAG. Then its count can be
 * derived, by taking the shared letter count and subtracting the count of all its parent nodes.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P423ReconstructOriginalDigitsFromEnglish {

  public String originalDigits(String s) {
    // count the relevant characters (those in the graph)
    int[] count = new int[10];
    for (char c : s.toCharArray()) {
      for (Node node : NODES) {
        if (node.c == c) {
          count[node.i]++;
        }
      }
    }

    // update counts for shared letters (a node shares a letter with it's children in the graph)
    // if a node is added to the queue, it means it has been processed (it's digit count is final)
    // must traverse BFS (level by level) so nodes are only processed after all their parents are
    // processed
    ArrayDeque<Node> q = new ArrayDeque<>(SOURCES);
    while (!q.isEmpty()) {
      Node node = q.remove();
      for (Node descendant : node.children) {
        count[descendant.i] -= count[node.i];
        q.add(descendant);
      }
    }

    return IntStream.rangeClosed(0, 9)
        .mapToObj(i -> String.valueOf(i).repeat(Math.max(0, count[i])))
        .collect(Collectors.joining());
  }

  private static final Set<Node> NODES;
  private static final Set<Node> SOURCES;

  static {
    //    Map<Integer, String> digits =
    //        Map.ofEntries(
    //            Map.entry(0, "zero"),
    //            Map.entry(1, "one"),
    //            Map.entry(2, "two"),
    //            Map.entry(3, "three"),
    //            Map.entry(4, "four"),
    //            Map.entry(5, "five"),
    //            Map.entry(6, "six"),
    //            Map.entry(7, "seven"),
    //            Map.entry(8, "eight"),
    //            Map.entry(9, "nine"));
    // TODO(will-molloy) programmatically compute the graph
    //  i.e. only hardcode the digit to english spelling
    Map<Integer, Node> nodes =
        Map.ofEntries(
            Map.entry(0, new Node(0, 'z')),
            Map.entry(1, new Node(1, 'o')),
            Map.entry(2, new Node(2, 'w')),
            Map.entry(3, new Node(3, 'h')),
            Map.entry(4, new Node(4, 'u')),
            Map.entry(5, new Node(5, 'f')),
            Map.entry(6, new Node(6, 'x')),
            Map.entry(7, new Node(7, 's')),
            Map.entry(8, new Node(8, 'g')),
            Map.entry(9, new Node(9, 'i')));
    nodes.get(0).children = Set.of(nodes.get(1));
    nodes.get(2).children = Set.of(nodes.get(1));
    nodes.get(4).children = Set.of(nodes.get(1), nodes.get(5));
    nodes.get(5).children = Set.of(nodes.get(9));
    nodes.get(6).children = Set.of(nodes.get(7));
    nodes.get(8).children = Set.of(nodes.get(3));

    NODES = Set.copyOf(nodes.values());
    SOURCES = Set.of(nodes.get(0), nodes.get(2), nodes.get(4), nodes.get(6), nodes.get(8));
  }

  private static final class Node {
    final int i;
    final char c;
    Set<Node> children = Set.of();

    Node(int i, char c) {
      this.i = i;
      this.c = c;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return i == node.i && c == node.c;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, c);
    }

    @Override
    public String toString() {
      return "Node{" + "i=" + i + ", c=" + c + '}';
    }
  }
}
