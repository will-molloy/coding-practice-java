package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P332ReconstructItineraryTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P332ReconstructItineraryTest {

  private final P332ReconstructItinerary p332 = new P332ReconstructItinerary();

  @Test
  void example1OnePath() {
    assertThat(
            p332.findItinerary(
                List.of(
                    List.of("MUC", "LHR"),
                    List.of("JFK", "MUC"),
                    List.of("SFO", "SJC"),
                    List.of("LHR", "SFO"))))
        .containsExactly("JFK", "MUC", "LHR", "SFO", "SJC")
        .inOrder();
  }

  @Test
  void example2ReconstructLexicographicallySmallest() {
    assertThat(
            p332.findItinerary(
                List.of(
                    List.of("JFK", "SFO"),
                    List.of("JFK", "ATL"),
                    List.of("SFO", "ATL"),
                    List.of("ATL", "JFK"),
                    List.of("ATL", "SFO"))))
        .containsExactly("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")
        .inOrder();
  }

  @Test
  void traverseLargerNodeFirstOtherwiseWontUseAllEdges() {
    assertThat(
            p332.findItinerary(
                List.of(
                    List.of("JFK", "AAA"),
                    List.of("JFK", "ZZZ"),
                    List.of("AAA", "ZZZ"),
                    List.of("ZZZ", "AAA"),
                    List.of("ZZZ", "JFK"))))
        .containsExactly("JFK", "AAA", "ZZZ", "JFK", "ZZZ", "AAA")
        .inOrder();
  }

  @Test
  void duplicateTicket() {
    assertThat(
            p332.findItinerary(
                List.of(
                    List.of("EZE", "AXA"),
                    List.of("TIA", "ANU"),
                    List.of("ANU", "JFK"),
                    List.of("JFK", "ANU"),
                    List.of("ANU", "EZE"),
                    List.of("TIA", "ANU"),
                    List.of("AXA", "TIA"),
                    List.of("TIA", "JFK"),
                    List.of("ANU", "TIA"),
                    List.of("JFK", "TIA"))))
        .containsExactly(
            "JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK")
        .inOrder();
  }
}
