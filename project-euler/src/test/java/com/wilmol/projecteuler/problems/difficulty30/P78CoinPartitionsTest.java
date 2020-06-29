package com.wilmol.projecteuler.problems.difficulty30;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P78CoinPartitionsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P78CoinPartitionsTest {

  @Test
  void firstPartitionDivisibleByOneMillion() {
    assertThat(P78CoinPartitions.findFirstPartitionDivisibleByOneMillion()).isEqualTo(55_374);
  }
}
