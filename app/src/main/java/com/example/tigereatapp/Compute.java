package com.example.tigereatapp;

/**
 * this is the computer.
 */
class Compute {
  /**
   * this os tje max function.
   *
   * @param num is the input
   * @return max value
   */
  public int getMax(int[] num) {
    int max = num[0];
    for (int i : num) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }
}