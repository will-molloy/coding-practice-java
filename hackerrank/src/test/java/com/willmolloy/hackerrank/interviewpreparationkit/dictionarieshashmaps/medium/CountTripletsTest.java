package com.willmolloy.hackerrank.interviewpreparationkit.dictionarieshashmaps.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * CountTripletsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@Timeout(value = 1)
final class CountTripletsTest {

  @ParameterizedTest
  @MethodSource("functions")
  void example(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 4L, 16L, 64L), 4)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void sampleInput0(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void sampleInput1(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)).isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void sampleInput2(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void ratioOfOneOneTriplet(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 1L, 1L), 1)).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void ratioOfOneManyOverlappingTriplets(CountTriplets fun) {
    // 100 choose 3 = 161700
    assertThat(fun.countTriplets(Collections.nCopies(100, 1L), 1)).isEqualTo(161700);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void ratioOfOneTwoTriplets(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 1L, 1L, 2L, 2L, 2L), 1)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void unsortedArrayBreaksIndexOrder(CountTriplets fun) {
    assertThat(fun.countTriplets(Arrays.asList(1L, 2L, 1L, 2L, 4L), 2)).isEqualTo(3);
  }

  static Stream<Arguments> functions() {
    return Stream.of(
        Arguments.of(new CountTriplets.NaiveSolution()),
        Arguments.of(new CountTriplets.LinearSolution()));
  }
}
