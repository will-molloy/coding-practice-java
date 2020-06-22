package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P133CloneGraph.Node;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-03. */
class P133CloneGraphTest {

  private final P133CloneGraph p133 = new P133CloneGraph();

  @Test
  void example1() {
    // Given
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);

    one.neighbors().add(two);
    one.neighbors().add(four);

    two.neighbors().add(one);
    two.neighbors().add(three);

    three.neighbors().add(two);
    three.neighbors().add(four);

    four.neighbors().add(one);
    four.neighbors().add(three);

    // When
    Node oneCopy = p133.cloneGraph(one);
    Node twoCopy = oneCopy.neighbors().get(0);
    Node threeCopy = twoCopy.neighbors().get(1);
    Node fourCopy = oneCopy.neighbors().get(1);

    // Then
    assertThat(oneCopy).isNotSameInstanceAs(one);
    assertThat(twoCopy).isNotSameInstanceAs(two);
    assertThat(threeCopy).isNotSameInstanceAs(three);
    assertThat(fourCopy).isNotSameInstanceAs(four);

    assertThat(oneCopy.val()).isEqualTo(1);
    assertThat(twoCopy.val()).isEqualTo(2);
    assertThat(threeCopy.val()).isEqualTo(3);
    assertThat(fourCopy.val()).isEqualTo(4);

    assertThat(oneCopy.neighbors()).containsExactly(twoCopy, fourCopy);
    assertThat(twoCopy.neighbors()).containsExactly(oneCopy, threeCopy);
    assertThat(threeCopy.neighbors()).containsExactly(twoCopy, fourCopy);
    assertThat(fourCopy.neighbors()).containsExactly(oneCopy, threeCopy);
  }

  @Test
  void example2() {
    // Given
    Node one = new Node(1);

    // When
    Node oneCopy = p133.cloneGraph(one);

    // Then
    assertThat(oneCopy).isNotSameInstanceAs(one);

    assertThat(oneCopy.val()).isEqualTo(1);

    assertThat(oneCopy.neighbors()).isEmpty();
  }

  @Test
  void example3() {
    assertThat(p133.cloneGraph(null)).isNull();
  }

  @Test
  void example4() {
    // Given
    Node one = new Node(1);
    Node two = new Node(2);
    one.neighbors().add(two);
    two.neighbors().add(one);

    // When
    Node oneCopy = p133.cloneGraph(one);
    Node twoCopy = oneCopy.neighbors().get(0);

    // Then
    assertThat(oneCopy).isNotSameInstanceAs(one);
    assertThat(twoCopy).isNotSameInstanceAs(two);

    assertThat(oneCopy.val()).isEqualTo(1);
    assertThat(twoCopy.val()).isEqualTo(2);

    assertThat(oneCopy.neighbors()).containsExactly(twoCopy);
    assertThat(twoCopy.neighbors()).containsExactly(oneCopy);
  }
}
