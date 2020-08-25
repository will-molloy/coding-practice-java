package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P983MinimumCostForTicketsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P983MinimumCostForTicketsTest {

  private final P983MinimumCostForTickets p983 = new P983MinimumCostForTickets();

  @Test
  void example1() {
    assertThat(p983.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}))
        .isEqualTo(11);
  }

  @Test
  void example2() {
    assertThat(
            p983.mincostTickets(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15}))
        .isEqualTo(17);
  }

  @Test
  void firstDayIsnt1() {
    assertThat(p983.mincostTickets(new int[] {2, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}))
        .isEqualTo(9);
  }

  @Test
  void contiguousMonthDayCheapest() {
    assertThat(p983.mincostTickets(IntStream.rangeClosed(1, 30).toArray(), new int[] {1, 8, 31}))
        .isEqualTo(30);
  }

  @Test
  void contiguousMonthWeekCheapest() {
    assertThat(p983.mincostTickets(IntStream.rangeClosed(1, 30).toArray(), new int[] {4, 7, 36}))
        .isEqualTo(35);
  }

  @Test
  void contiguousMonthMonthCheapest() {
    assertThat(p983.mincostTickets(IntStream.rangeClosed(1, 30).toArray(), new int[] {4, 7, 34}))
        .isEqualTo(34);
  }

  @Test
  void example1TicketCostsReversed() {
    assertThat(p983.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {15, 7, 2}))
        .isEqualTo(2);
  }

  @Test
  void sparseWeek() {
    assertThat(p983.mincostTickets(new int[] {1, 7}, new int[] {2, 3, 4})).isEqualTo(3);
  }

  @Test
  void sparseMonth() {
    assertThat(p983.mincostTickets(new int[] {1, 30}, new int[] {2, 3, 4})).isEqualTo(4);
  }

  @Test
  void lookBack7DaysNot6() {
    assertThat(
            p983.mincostTickets(
                new int[] {1, 4, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 27, 28},
                new int[] {3, 13, 45}))
        .isEqualTo(44);
  }
}
