package wilmol.hackerrank.regex.backreference.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-06 at 20:30. */
class ForwardReferencesTest {

  @Test
  void testMatches() {
    assertThat(new ForwardReferences().matches("tactactic")).isTrue();
    assertThat(new ForwardReferences().matches("tactactictactic")).isTrue();
    assertThat(new ForwardReferences().matches("tac")).isTrue();
    assertThat(new ForwardReferences().matches("tactac")).isTrue();
    assertThat(new ForwardReferences().matches("tactactactic")).isTrue();
    assertThat(new ForwardReferences().matches("tactactactactactac")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new ForwardReferences().matches("tactactictactictictac")).isFalse();
    assertThat(new ForwardReferences().matches("tactictac")).isFalse();
    assertThat(new ForwardReferences().matches("tactic")).isFalse();
    assertThat(new ForwardReferences().matches("tic")).isFalse();
    assertThat(new ForwardReferences().matches("tactactictic")).isFalse();
  }
}
