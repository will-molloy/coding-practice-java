package wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 24/03/2019. */
class RansomNoteTest {

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
