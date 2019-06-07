package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.regex.applications.easy.DetectHTMLTags.extractTags;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class DetectHTMLTagsTest
{

  @Test
  void extractTagsWithLeadingBraceOrWhitespace()
  {
    Stream<String> lines = Stream.of(
        "<p><a href=\"http://www.quackit.com/html/tutorial/html_links.cfm\">Example Link</a></p>",
        "<div class=\"more-info\"><a href=\"http://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a></div>");
    assertThat(extractTags(lines)).isEqualTo("a;div;p");
  }

  @Test
  void extractTagsWithoutClosingTag()
  {
    Stream<String> lines = Stream.of(
        "<li>",
        "<li style=\"-moz-float-edge: content-box\">... that in <i><b><a href=\"/wiki/La%C3%9Ft_uns_sorgen,_la%C3%9Ft_uns_wachen,_BWV_213\" title=\"Lat uns sorgen, lat uns wachen, BWV 213\">Die Wahl des Herkules</a></b></i>, Hercules must choose between the good cop and the bad cop?<br style=\"clear:both;\" />",
        "</li>");
    assertThat(extractTags(lines)).isEqualTo("a;b;br;i;li");
  }

  @Test
  void extractTagsWithTrailingWhiteSpace()
  {
    Stream<String> lines = Stream.of(
        "<   center >",
        "<div class=\"noresize\" style=\"height: 242px; width: 600px; \"><map name=\"ImageMap_1_971996215\" id=\"ImageMap_1_971996215\">",
        "</div>",
        "</center>");
    assertThat(extractTags(lines)).isEqualTo("center;div;map");
  }

  @Test
  void extractTagsWithDigitCharacters()
  {
    Stream<String> lines = Stream.of(
        "<h2><span class=\"mw-headline\" id=\"Other_areas_of_Wikipedia\">Other areas of Wikipedia</span></h2>");
    assertThat(extractTags(lines)).isEqualTo("h2;span");
  }

}
