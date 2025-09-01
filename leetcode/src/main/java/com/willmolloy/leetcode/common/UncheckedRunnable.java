package com.willmolloy.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * UncheckedRunnable.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings(
    value = {
      "THROWS_METHOD_THROWS_RUNTIMEEXCEPTION",
      "THROWS_METHOD_THROWS_CLAUSE_BASIC_EXCEPTION"
    },
    justification = "That's the point of this interface.")
@FunctionalInterface
public interface UncheckedRunnable extends Runnable {
  @Override
  default void run() {
    try {
      uncheckedRun();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  void uncheckedRun() throws Exception;
}
