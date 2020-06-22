package com.wilmol.leetcode.common;

/** Created by Will on 2019-07-19 at 21:16. */
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
