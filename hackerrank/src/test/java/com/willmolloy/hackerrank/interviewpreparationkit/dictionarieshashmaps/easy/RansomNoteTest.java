package com.willmolloy.hackerrank.interviewpreparationkit.dictionarieshashmaps.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * RansomNoteTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class RansomNoteTest {

  @Test
  void canConstructNote() {
    assertThat(
            RansomNote.checkMagazine(
                new String[] {"give", "me", "one", "grand", "today"},
                new String[] {"give", "one", "grand", "today"}))
        .isTrue();
  }

  @Test
  void cannotConstructNote() {
    assertThat(
            RansomNote.checkMagazine(
                new String[] {"give", "me", "one", "grand", "tonight"},
                new String[] {"give", "one", "grand", "today"}))
        .isFalse();
  }
}
