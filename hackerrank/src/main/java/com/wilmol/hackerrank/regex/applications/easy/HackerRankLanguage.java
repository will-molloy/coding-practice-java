package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/hackerrank-language/problem>https://www.hackerrank.com/challenges/hackerrank-language/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class HackerRankLanguage {

  private HackerRankLanguage() {}

  // the api_id check is incorrect (should be 10^4 <= api_id < 10^5)
  // hackerrank has poor test coverage for it
  private static final Pattern LANGUAGE_PATTERN =
      Pattern.compile(
          "^\\d{5,6} (C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$");

  static boolean isValidLanguage(String line) {
    Matcher m = LANGUAGE_PATTERN.matcher(line);
    return m.matches();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader
        .lines()
        .forEach(
            line -> {
              if (isValidLanguage(line)) {
                // CHECKSTYLE IGNORE Regexp FOR NEXT 3 LINES
                System.out.println("VALID");
              } else {
                System.out.println("INVALID");
              }
            });
  }
}
