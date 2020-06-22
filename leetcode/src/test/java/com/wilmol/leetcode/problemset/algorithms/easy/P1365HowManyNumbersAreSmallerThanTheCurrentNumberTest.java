package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-04-02. */
class P1365HowManyNumbersAreSmallerThanTheCurrentNumberTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P1365HowManyNumbersAreSmallerThanTheCurrentNumber fun) {
    assertThat(fun.smallerNumbersThanCurrent(new int[] {8, 1, 2, 2, 3}))
        .asList()
        .containsExactly(4, 0, 1, 1, 3)
        .inOrder();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P1365HowManyNumbersAreSmallerThanTheCurrentNumber fun) {
    assertThat(fun.smallerNumbersThanCurrent(new int[] {7, 7, 7, 7}))
        .asList()
        .containsExactly(0, 0, 0, 0)
        .inOrder();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void lowestPossibleValueZeroIsPresent(P1365HowManyNumbersAreSmallerThanTheCurrentNumber fun) {
    assertThat(fun.smallerNumbersThanCurrent(new int[] {5, 0, 10, 0, 10, 6}))
        .asList()
        .containsExactly(2, 0, 4, 0, 4, 3)
        .inOrder();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void allPossibleValuesArePresent(P1365HowManyNumbersAreSmallerThanTheCurrentNumber fun) {
    int[] nums = IntStream.rangeClosed(0, 100).toArray();
    assertThat(fun.smallerNumbersThanCurrent(nums))
        .asList()
        .containsExactlyElementsIn(Ints.asList(nums))
        .inOrder();
  }

  static Stream<P1365HowManyNumbersAreSmallerThanTheCurrentNumber> funs() {
    return Stream.of(
        new P1365HowManyNumbersAreSmallerThanTheCurrentNumber.SortedMap(),
        new P1365HowManyNumbersAreSmallerThanTheCurrentNumber.Array());
  }
}
