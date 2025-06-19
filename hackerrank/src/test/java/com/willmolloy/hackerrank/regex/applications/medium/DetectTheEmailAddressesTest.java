package com.willmolloy.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * DetectTheEmailAddressesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class DetectTheEmailAddressesTest {

  @Test
  void noDuplicates() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a@b.c", "a@b.c")))
        .isEqualTo("a@b.c");
  }

  @Test
  void requireAtLeastOneLeadingDomain() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("@a.b"))).isEmpty();
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a@b.c"))).isEqualTo("a@b.c");
  }

  @Test
  void requireAtLeastTwoTrailingDomains() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a@"))).isEmpty();
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a@b"))).isEmpty();
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a@b.c"))).isEqualTo("a@b.c");
  }

  @Test
  void allowMultipleTrailingDomains() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a@b.c.d.e")))
        .isEqualTo("a@b.c.d.e");
  }

  @Test
  void allowMultipleLeadingDomains() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(List.of("a.b@c.d")))
        .isEqualTo("a.b@c.d");
  }

  @Test
  void extractMultipleFromDifferentOrSameLineIntoLexicographicalOrder() {
    assertThat(
            DetectTheEmailAddresses.extractEmailAddresses(
                List.of("a.b@c.d, a.b@c.d a@b.c a.b@c.d", "a.b@c.d haha a@b.c")))
        .isEqualTo("a.b@c.d;a@b.c");
  }
}
