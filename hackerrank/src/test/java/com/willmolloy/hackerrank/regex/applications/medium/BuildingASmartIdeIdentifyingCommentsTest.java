package com.willmolloy.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * BuildingASmartIdeIdentifyingCommentsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class BuildingASmartIdeIdentifyingCommentsTest {

  @Test
  void singleLineComments() {
    assertThat(
            BuildingASmartIdeIdentifyingComments.extractComments(
                List.of(
                    "// this is a single line comment",
                    "x = 1 // a single line comment after code")))
        .containsExactly("// this is a single line comment", "// a single line comment after code")
        .inOrder();
  }

  @Test
  void multiLineCommentsMustRemoveLeadingWhiteSpaceAndNotCollapseIntoOneLine() {
    assertThat(
            BuildingASmartIdeIdentifyingComments.extractComments(
                List.of(
                    "/* This is one way of writing comments */ ",
                    "/* This is a multiline ",
                    "   comment. These can often",
                    "   be useful*/")))
        .containsExactly(
            "/* This is one way of writing comments */",
            "/* This is a multiline ",
            "comment. These can often",
            "be useful*/")
        .inOrder();
  }

  @Test
  void sampleInput00() {
    assertThat(
            BuildingASmartIdeIdentifyingComments.extractComments(
                List.of(
                    " // my  program in C++",
                    "",
                    "#include <iostream>",
                    "/** playing around in",
                    "a new programming language **/",
                    "using namespace std;",
                    "",
                    "int main ()",
                    "{",
                    "  cout << \"Hello World\";",
                    "  cout << \"I'm a C++ program\"; //use cout",
                    "  return 0;",
                    "}")))
        .containsExactly(
            "// my  program in C++",
            "/** playing around in",
            "a new programming language **/",
            "//use cout")
        .inOrder();
  }
}
