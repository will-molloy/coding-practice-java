package com.wilmol.hackerrank.regex.applications.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by wilmol on 2019-11-01.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/detect-html-links/problem>https://www.hackerrank.com/challenges/detect-html-links/problem</a>
 *
 * <p>The last hackerrank regex problem! And the one with lowest acceptance rate; really using all
 * the moves here.
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: joining into one line so single regex can be used, capturing groups, mixing greedy and
 * lazy quantification.
 *
 * <p>TODO refactor all these problems (the {@link com.wilmol.hackerrank.regex.applications} ones)
 * to use a single regex? Kinda cheating to use multiple regex.
 *
 * @see com.wilmol.hackerrank.regex.applications.easy.DetectHtmlAttributes
 * @see com.wilmol.hackerrank.regex.applications.easy.DetectHtmlTags
 */
final class DetectHtmlLinks {

  private DetectHtmlLinks() {}

  /**
   * Extract the {@code <a>} tag contents. Uses lazy quantification so only matches single {@code
   * <a>} tag each {@code find()}.
   *
   * <p>TODO is it possible to use a single regex?? Had issues with it matching all the {@code <a>}
   * tags into a single group (i.e. it something like {@code <a></a><a></a>}, how to stop it being
   * greedy?).
   */
  private static final Pattern A_TAG_PATTERN = Pattern.compile("<a href.+?</a>");

  /**
   * Extract the link and title from the {@code <a>} tag.
   *
   * <p>group 1 will hold the link, group 3 the title (title could be empty) (lazily).
   *
   * <p>groups 2 and 4 account for the possible tags surrounding the title (greedily).
   */
  private static final Pattern A_TAG_LINK_AND_TITLE_PATTERN =
      Pattern.compile("<a href=\"(.+?)\".*?>(<.*?>)*(.*?)(</.*?>)*</a>");

  static List<String> detectLinks(List<String> input) {
    // join into one string since html may span multi line
    // problem said to use new line for each link, so can remove the linebreaks
    String join = String.join("", input);

    // extract the tags
    Matcher tagMatcher = A_TAG_PATTERN.matcher(join);
    List<String> list = new ArrayList<>();
    // standard find() loop
    while (tagMatcher.find()) {
      String aTag = tagMatcher.group();
      // extract the attributes (link and title)
      Matcher attributeMatcher = A_TAG_LINK_AND_TITLE_PATTERN.matcher(aTag);
      if (attributeMatcher.find()) {
        String link = attributeMatcher.group(1).trim();
        String title = attributeMatcher.group(3).trim();
        list.add(link + "," + title);
      }
    }
    return list;
  }

  public static void main(String[] args) throws IOException {
    // main function, gets things rolling
    try (BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      // first line is a number won't be html don't care about it
      List<String> input = bufferedReader.lines().collect(Collectors.toList());
      List<String> links = detectLinks(input);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      links.forEach(System.out::println);
    }
  }
}
