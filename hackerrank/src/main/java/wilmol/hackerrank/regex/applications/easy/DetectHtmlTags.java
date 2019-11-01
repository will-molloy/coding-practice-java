package wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Will on 2019-04-07 at 11:38.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/detect-html-tags/problem>https://www.hackerrank.com/challenges/detect-html-tags/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @see DetectHtmlAttributes
 * @see wilmol.hackerrank.regex.applications.medium.DetectHtmlLinks
 */
final class DetectHtmlTags {

  private DetectHtmlTags() {}

  // match on the opening tag (may not be a closing tag)
  private static final Pattern HTML_TAG_PATTERN = Pattern.compile("(?<=<)\\s*[\\w]+(?=(\\s|>))");

  static String extractTags(Stream<String> lines) {
    return lines
        .flatMap(
            line -> {
              Matcher m = HTML_TAG_PATTERN.matcher(line);
              return IntStream.iterate(0, n -> n + 1)
                  .takeWhile(n -> m.find())
                  // need trim in case there is trailing white space
                  // way around this? problem is 'A lookbehind assertion has to be fixed width'
                  // i.e. cannot put \s* in the lookbehind ..
                  .mapToObj(n -> m.group().trim());
            })
        .distinct()
        .sorted()
        .collect(Collectors.joining(";"));
  }

  public static void main(String[] args) {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    String tags = extractTags(reader.lines());
    // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
    System.out.println(tags);
  }
}
