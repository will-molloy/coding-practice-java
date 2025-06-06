package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P39IntegerRightTrianglesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P39IntegerRightTrianglesTest {

  @Test
  void perimeterBelow1000WithMaxNumberOfSolutions() {
    assertThat(P39IntegerRightTriangles.perimeterWithMaxNumberOfSolutions(1000)).isEqualTo(840);
  }

  @Test
  void numberOfSolutionsForPerimeterOf120() {
    assertThat(P39IntegerRightTriangles.numberOfSolutions(120)).isEqualTo(3);
  }
}
