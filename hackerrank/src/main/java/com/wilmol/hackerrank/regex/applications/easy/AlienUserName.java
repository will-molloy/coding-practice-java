package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-07 at 13:45
 * <p>
 * https://www.hackerrank.com/challenges/alien-username/problem
 * <p>
 * Runtime: O(n)
 */
class AlienUserName
{

  private static final Pattern USER_NAME_PATTERN = Pattern.compile("^(_|[.])\\d+[a-zA-Z]*_?$");

  static boolean isValidUserName(String userName)
  {
    Matcher m = USER_NAME_PATTERN.matcher(userName);
    return m.matches();
  }

  public static void main(String[] args)
    throws IOException
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    reader.readLine(); // ignore (num lines)
    reader.lines()
        .forEach(line ->
        {
          if (isValidUserName(line))
          {
            System.out.println("VALID");
          }
          else
          {
            System.out.println("INVALID");
          }
        });
  }

}
