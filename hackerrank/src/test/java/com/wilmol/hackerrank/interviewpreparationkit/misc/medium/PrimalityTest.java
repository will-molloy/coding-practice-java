package com.wilmol.hackerrank.interviewpreparationkit.misc.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * PrimalityTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class PrimalityTest {

  @Test
  void isPrime() {
    List<Integer> fewPrimes = List.of(1, 2, 3, 31, 33, 156, 901, 3333);
    List<Boolean> expected = List.of(false, true, true, true, false, false, false, false);
    assertThat(fewPrimes.size() == expected.size()).isTrue();
    for (int i = 0; i < fewPrimes.size(); i++) {
      assertThat(Primality.primality(fewPrimes.get(i))).isEqualTo(expected.get(i));
    }
  }
}
