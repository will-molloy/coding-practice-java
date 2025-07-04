package com.willmolloy.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * DetectTheDomainNameTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class DetectTheDomainNameTest {

  @Test
  void stripWww() {
    assertThat(DetectTheDomainName.extractDomainNames(List.of("http://www.google.com")))
        .isEqualTo("google.com");
  }

  @Test
  void allowNumbers() {
    assertThat(DetectTheDomainName.extractDomainNames(List.of("http://www.g123oogle.com")))
        .isEqualTo("g123oogle.com");
  }

  @Test
  void allowDashes() {
    assertThat(DetectTheDomainName.extractDomainNames(List.of("http://www.face-book.com")))
        .isEqualTo("face-book.com");
  }

  @Test
  void allowVariousDomains() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                List.of("http://a.net", "https://b.org http://c.com")))
        .isEqualTo("a.net;b.org;c.com");
  }

  @Test
  void disallowMissingDomain() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                List.of("http://google", "http://google com", "http://google,com")))
        .isEmpty();
  }

  @Test
  void disallowMissingHttp() {
    assertThat(DetectTheDomainName.extractDomainNames(List.of("google.com"))).isEmpty();
  }

  @Test
  void noDuplicates() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                List.of("http://google.com http://www.google.com", "http://google.com")))
        .isEqualTo("google.com");
  }

  @Test
  void orderResultLexicographically() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                List.of("http://c.com http://a.com", "http://b.com")))
        .isEqualTo("a.com;b.com;c.com");
  }
}
