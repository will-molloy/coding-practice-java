package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P1424DiagonalTraverse2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1424DiagonalTraverse2Test {

  private final P1424DiagonalTraverse2 p1424 = new P1424DiagonalTraverse2();

  @Test
  void example1() {
    assertThat(
            p1424.findDiagonalOrder(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9))))
        .asList()
        .containsExactly(1, 4, 2, 7, 5, 3, 8, 6, 9)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p1424.findDiagonalOrder(
                List.of(
                    List.of(1, 2, 3, 4, 5),
                    List.of(6, 7),
                    List.of(8),
                    List.of(9, 10, 11),
                    List.of(12, 13, 14, 15, 16))))
        .asList()
        .containsExactly(1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16)
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(
            p1424.findDiagonalOrder(
                List.of(
                    List.of(1, 2, 3),
                    List.of(4),
                    List.of(5, 6, 7),
                    List.of(8),
                    List.of(9, 10, 11))))
        .asList()
        .containsExactly(1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11)
        .inOrder();
  }

  @Test
  void example4() {
    assertThat(p1424.findDiagonalOrder(List.of(List.of(1, 2, 3, 4, 5, 6))))
        .asList()
        .containsExactly(1, 2, 3, 4, 5, 6)
        .inOrder();
  }

  @Test
  void lastRowIsntTheLongest() {
    assertThat(
            p1424.findDiagonalOrder(
                List.of(List.of(1, 2, 3), List.of(4, 5, 6, 7, 8, 9), List.of(10, 11, 12))))
        .asList()
        .containsExactly(1, 4, 2, 10, 5, 3, 11, 6, 12, 7, 8, 9)
        .inOrder();
  }
}
