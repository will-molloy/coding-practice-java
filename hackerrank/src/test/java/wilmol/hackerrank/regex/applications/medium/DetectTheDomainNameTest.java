package wilmol.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-10-20. */
class DetectTheDomainNameTest {

  @Test
  void stripWww() {
    assertThat(DetectTheDomainName.extractDomainNames(ImmutableList.of("http://www.google.com")))
        .isEqualTo("google.com");
  }

  @Test
  void allowNumbers() {
    assertThat(DetectTheDomainName.extractDomainNames(ImmutableList.of("http://www.g123oogle.com")))
        .isEqualTo("g123oogle.com");
  }

  @Test
  void allowDashes() {
    assertThat(DetectTheDomainName.extractDomainNames(ImmutableList.of("http://www.face-book.com")))
        .isEqualTo("face-book.com");
  }

  @Test
  void allowVariousDomains() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                ImmutableList.of("http://a.net", "https://b.org http://c.com")))
        .isEqualTo("a.net;b.org;c.com");
  }

  @Test
  void disallowMissingDomain() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                ImmutableList.of("http://google", "http://google com", "http://google,com")))
        .isEmpty();
  }

  @Test
  void disallowMissingHttp() {
    assertThat(DetectTheDomainName.extractDomainNames(ImmutableList.of("google.com"))).isEmpty();
  }

  @Test
  void noDuplicates() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                ImmutableList.of("http://google.com http://www.google.com", "http://google.com")))
        .isEqualTo("google.com");
  }

  @Test
  void orderResultLexicographically() {
    assertThat(
            DetectTheDomainName.extractDomainNames(
                ImmutableList.of("http://c.com http://a.com", "http://b.com")))
        .isEqualTo("a.com;b.com;c.com");
  }
}
