package com.fpinjava.functions.exercise02_12;

public class FunctionExamples {

  /*
   * Note: The same implementation may be used for all four cases.
   */

  public static final Function<Integer, Integer> factorial0 = x -> x==0 ? 1 : x * FunctionExamples.factorial0.apply(x - 1);

  public static Function<Integer, Integer> factorial1;
  static {
    factorial1 = x -> x==0 ? 1 : x * factorial1.apply(x - 1);
  }

  public final Function<Integer, Integer> factorial2 = x -> x==0 ? 1 : x * this.factorial2.apply(x - 1);

  public Function<Integer, Integer> factorial3;
  {
    factorial3 = x -> x==0 ? 1 : x * this.factorial3.apply(x - 1);
  }
}
