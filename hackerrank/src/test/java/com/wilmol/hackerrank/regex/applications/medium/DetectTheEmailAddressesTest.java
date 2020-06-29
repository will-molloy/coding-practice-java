package com.wilmol.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * DetectTheEmailAddressesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class DetectTheEmailAddressesTest {

  @Test
  void noDuplicates() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a@b.c", "a@b.c")))
        .isEqualTo("a@b.c");
  }

  @Test
  void requireAtLeastOneLeadingDomain() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("@a.b"))).isEmpty();
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a@b.c")))
        .isEqualTo("a@b.c");
  }

  @Test
  void requireAtLeastTwoTrailingDomains() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a@"))).isEmpty();
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a@b"))).isEmpty();
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a@b.c")))
        .isEqualTo("a@b.c");
  }

  @Test
  void allowMultipleTrailingDomains() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a@b.c.d.e")))
        .isEqualTo("a@b.c.d.e");
  }

  @Test
  void allowMultipleLeadingDomains() {
    assertThat(DetectTheEmailAddresses.extractEmailAddresses(ImmutableList.of("a.b@c.d")))
        .isEqualTo("a.b@c.d");
  }

  @Test
  void extractMultipleFromDifferentOrSameLineIntoLexicographicalOrder() {
    assertThat(
            DetectTheEmailAddresses.extractEmailAddresses(
                ImmutableList.of("a.b@c.d, a.b@c.d a@b.c a.b@c.d", "a.b@c.d haha a@b.c")))
        .isEqualTo("a.b@c.d;a@b.c");
  }
}
