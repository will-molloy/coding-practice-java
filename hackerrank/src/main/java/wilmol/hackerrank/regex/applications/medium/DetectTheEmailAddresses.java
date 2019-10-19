package wilmol.hackerrank.regex.applications.medium;

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
 * Created by wilmol on 2019-10-19.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/detect-the-email-addresses/problem>https://www.hackerrank.com/challenges/detect-the-email-addresses/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: gathering the requirements for an email (looked at the test cases) to construct the
 * regex. Otherwise a standard {@code find()} loop.
 *
 * @see DetectTheDomainName
 */
final class DetectTheEmailAddresses {

  private DetectTheEmailAddresses() {}

  private static final Pattern EMAIL_PATTERN = Pattern.compile("((\\w+[.])*\\w+@(\\w+[.])+\\w+)");

  static String extractEmailAddresses(List<String> lines) {
    Set<String> set = new HashSet<>();
    for (String line : lines) {
      Matcher m = EMAIL_PATTERN.matcher(line);
      while (m.find()) {
        String emailAddress = m.group(1);
        set.add(emailAddress);
      }
    }
    return set.stream().sorted().collect(Collectors.joining(";"));
  }

  public static void main(String... args) throws IOException {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      // initial line won't have an email address, don't worry about it
      List<String> lines = reader.lines().collect(Collectors.toList());
      String emailAddresses = extractEmailAddresses(lines);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      System.out.println(emailAddresses);
    }
  }
}
