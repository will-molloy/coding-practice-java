package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-02 at 21:28
 * <p>
 * https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem
 */
class MatchAnythingButNewLine
    implements
    Regex
{
  @Override
  public String regex()
  {
    // . -> anything but new line
    // \. -> escapes '.' (matches only exactly '.')
    return "...\\....\\....\\....";
  }
}
