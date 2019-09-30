package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-19 at 7:54 PM. */
class P39IntegerRightTrianglesTest {

  @Test
  void perimeterBelow1000WithMaxNumberOfSolutions() {
    assertThat(P39IntegerRightTriangles.perimeterWithMaxNumberOfSolutions(1000)).isEqualTo(840);
  }

  @Test
  void numberOfSolutionsForPerimeterOf120() {
    assertThat(P39IntegerRightTriangles.numberOfSolutions(120)).isEqualTo(3);
  }
}
