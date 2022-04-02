package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P332ReconstructItineraryTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P332ReconstructItineraryTest {

  private final P332ReconstructItinerary p332 = new P332ReconstructItinerary();

  @Test
  void example1OnePath() {
    assertThat(
            p332.findItinerary(
                ImmutableList.of(
                    ImmutableList.of("MUC", "LHR"),
                    ImmutableList.of("JFK", "MUC"),
                    ImmutableList.of("SFO", "SJC"),
                    ImmutableList.of("LHR", "SFO"))))
        .containsExactly("JFK", "MUC", "LHR", "SFO", "SJC")
        .inOrder();
  }

  @Test
  void example2ReconstructLexicographicallySmallest() {
    assertThat(
            p332.findItinerary(
                ImmutableList.of(
                    ImmutableList.of("JFK", "SFO"),
                    ImmutableList.of("JFK", "ATL"),
                    ImmutableList.of("SFO", "ATL"),
                    ImmutableList.of("ATL", "JFK"),
                    ImmutableList.of("ATL", "SFO"))))
        .containsExactly("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")
        .inOrder();
  }

  @Test
  void traverseLargerNodeFirstOtherwiseWontUseAllEdges() {
    assertThat(
            p332.findItinerary(
                ImmutableList.of(
                    ImmutableList.of("JFK", "AAA"),
                    ImmutableList.of("JFK", "ZZZ"),
                    ImmutableList.of("AAA", "ZZZ"),
                    ImmutableList.of("ZZZ", "AAA"),
                    ImmutableList.of("ZZZ", "JFK"))))
        .containsExactly("JFK", "AAA", "ZZZ", "JFK", "ZZZ", "AAA")
        .inOrder();
  }

  @Test
  void duplicateTicket() {
    assertThat(
            p332.findItinerary(
                ImmutableList.of(
                    ImmutableList.of("EZE", "AXA"),
                    ImmutableList.of("TIA", "ANU"),
                    ImmutableList.of("ANU", "JFK"),
                    ImmutableList.of("JFK", "ANU"),
                    ImmutableList.of("ANU", "EZE"),
                    ImmutableList.of("TIA", "ANU"),
                    ImmutableList.of("AXA", "TIA"),
                    ImmutableList.of("TIA", "JFK"),
                    ImmutableList.of("ANU", "TIA"),
                    ImmutableList.of("JFK", "TIA"))))
        .containsExactly(
            "JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK")
        .inOrder();
  }
}
