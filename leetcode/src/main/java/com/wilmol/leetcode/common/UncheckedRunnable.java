package com.wilmol.leetcode.common;

/**
 * UncheckedRunnable.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
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
