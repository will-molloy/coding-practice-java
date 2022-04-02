package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1487MakingFileNamesUniqueTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1487MakingFileNamesUniqueTest {

  private final P1487MakingFileNamesUnique p1487 = new P1487MakingFileNamesUnique();

  @Test
  void example1NoSuffixingNeeded() {
    assertThat(p1487.getFolderNames(new String[] {"pes", "fifa", "gta", "pes(2019)"}))
        .asList()
        .containsExactly("pes", "fifa", "gta", "pes(2019)")
        .inOrder();
  }

  @Test
  void example2SuffixProcedureCreatesReservedNameSoSuffixAgain() {
    assertThat(p1487.getFolderNames(new String[] {"gta", "gta(1)", "gta", "avalon"}))
        .asList()
        .containsExactly("gta", "gta(1)", "gta(2)", "avalon")
        .inOrder();
  }

  @Test
  void example3RepeatSuffixProcedureForFirstUnreservedName() {
    assertThat(
            p1487.getFolderNames(
                new String[] {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}))
        .asList()
        .containsExactly("onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)")
        .inOrder();
  }

  @Test
  void example4SuffixInOrder() {
    assertThat(p1487.getFolderNames(new String[] {"wano", "wano", "wano", "wano"}))
        .asList()
        .containsExactly("wano", "wano(1)", "wano(2)", "wano(3)")
        .inOrder();
  }

  @Test
  void example5SuffixTwice() {
    assertThat(p1487.getFolderNames(new String[] {"kaido", "kaido(1)", "kaido", "kaido(1)"}))
        .asList()
        .containsExactly("kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)")
        .inOrder();
  }

  @Test
  void mustTakeEarliestSuffix() {
    assertThat(p1487.getFolderNames(new String[] {"ji", "ji(4)", "ji"}))
        .asList()
        .containsExactly("ji", "ji(4)", "ji(1)")
        .inOrder();
  }

  @Test
  void suffixTwiceBecauseNameBecomesReservedDuringTheProcedure() {
    assertThat(p1487.getFolderNames(new String[] {"j", "j(4)", "j", "j(1)"}))
        .asList()
        .containsExactly("j", "j(4)", "j(1)", "j(1)(1)")
        .inOrder();
  }
}
