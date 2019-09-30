package wilmol.projecteuler.problems.difficulty30;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-22 at 8:25 PM. */
class P78CoinPartitionsTest {

  @Test
  void firstPartitionDivisibleByOneMillion() {
    assertThat(P78CoinPartitions.findFirstPartitionDivisibleByOneMillion()).isEqualTo(55_374);
  }
}
