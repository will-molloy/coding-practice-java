package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-14. */
class P787CheapestFlightsWithinKStopsTest {

  @ParameterizedTest
  @MethodSource("p787")
  void example1(P787CheapestFlightsWithinKStops p787) {
    assertThat(
            p787.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1))
        .isEqualTo(200);
  }

  @ParameterizedTest
  @MethodSource("p787")
  void example2LimitedByK(P787CheapestFlightsWithinKStops p787) {
    assertThat(
            p787.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0))
        .isEqualTo(500);
  }

  @ParameterizedTest
  @MethodSource("p787")
  void takeLargerCostInitiallyOtherwiseLimitedByK(P787CheapestFlightsWithinKStops p787) {
    assertThat(
            p787.findCheapestPrice(
                4, new int[][] {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1))
        .isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("p787")
  void cantReachDestination(P787CheapestFlightsWithinKStops p787) {
    assertThat(
            p787.findCheapestPrice(
                5,
                new int[][] {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}},
                2,
                1,
                1))
        .isEqualTo(-1);
  }

  static Stream<P787CheapestFlightsWithinKStops> p787() {
    return Stream.of(
        new P787CheapestFlightsWithinKStops.Bfs(), new P787CheapestFlightsWithinKStops.Dijkstra());
  }
}
