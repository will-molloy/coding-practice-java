package com.willmolloy.hackerrank.regex.applications.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/detect-the-domain-name/problem>https://www.hackerrank.com/challenges/detect-the-domain-name/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key idea: figuring out the domain name regex, otherwise standard {@code find()} loop.
 *
 * @see DetectTheEmailAddresses
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class DetectTheDomainName {

  private static final String VALID_CHARS = "[a-z\\d\\-]";

  /**
   * Domain name regex pattern.
   *
   * <p>Want to extract on group 2.
   */
  private static final Pattern DOMAIN_NAME_PATTERN =
      Pattern.compile("https?://(www2?[.])?((" + VALID_CHARS + "+[.])+" + VALID_CHARS + "+)");

  static String extractDomainNames(List<String> lines) {
    Set<String> set = new HashSet<>();
    for (String line : lines) {
      Matcher domainNameMatcher = DOMAIN_NAME_PATTERN.matcher(line);
      while (domainNameMatcher.find()) {
        String domainName = domainNameMatcher.group(2);
        set.add(domainName);
      }
    }
    return set.stream().sorted().collect(Collectors.joining(";"));
  }

  public static void main(String... args) throws IOException {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      // first line won't have a domain name, don't care about it
      List<String> lines = reader.lines().collect(Collectors.toList());
      String extractedDomainNames = extractDomainNames(lines);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      System.out.println(extractedDomainNames);
    }
  }

  private DetectTheDomainName() {}
}
