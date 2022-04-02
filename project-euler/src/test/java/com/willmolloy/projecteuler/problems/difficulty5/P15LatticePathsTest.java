package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * P15LatticePathsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P15LatticePathsTest {

  private final P15LatticePaths latticePaths = new P15LatticePaths();

  @Test
  void test2x2Grid() {
    assertThat(latticePaths.apply(2, 2)).isEqualTo(BigInteger.valueOf(6));
  }

  @Test
  void test20x20Grid() {
    assertThat(latticePaths.apply(20, 20)).isEqualTo(BigInteger.valueOf(137_846_528_820L));
  }
}
