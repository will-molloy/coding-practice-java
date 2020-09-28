package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.DoubleStream;
import org.junit.jupiter.api.Test;

/**
 * P399EvaluateDivisionTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P399EvaluateDivisionTest {

  private final P399EvaluateDivision p399 = new P399EvaluateDivision();

  @Test
  void example1() {
    List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
    double[] values = DoubleStream.of(2, 3).toArray();
    List<List<String>> queries =
        List.of(
            List.of("a", "c"),
            List.of("b", "a"),
            List.of("a", "e"),
            List.of("a", "a"),
            List.of("x", "x"));
    assertThat(p399.calcEquation(equations, values, queries))
        .usingExactEquality()
        .containsExactly(6, 0.5, -1, 1, -1)
        .inOrder();
  }

  @Test
  void example2() {
    List<List<String>> equations =
        List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
    double[] values = DoubleStream.of(1.5, 2.5, 5.0).toArray();
    List<List<String>> queries =
        List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc"));
    assertThat(p399.calcEquation(equations, values, queries))
        .usingExactEquality()
        .containsExactly(3.75000, 0.40000, 5.00000, 0.20000)
        .inOrder();
  }

  @Test
  void example3() {
    List<List<String>> equations = List.of(List.of("a", "b"));
    double[] values = DoubleStream.of(0.5).toArray();
    List<List<String>> queries =
        List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y"));
    assertThat(p399.calcEquation(equations, values, queries))
        .usingExactEquality()
        .containsExactly(0.50000, 2.00000, -1.00000, -1.00000)
        .inOrder();
  }
}
